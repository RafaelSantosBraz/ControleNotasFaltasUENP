package dao;

import java.io.Serializable;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import modelo.Aluno;
import modelo.Disciplina;
import util.JpaUtil;

public class DisciplinaDao implements Serializable {

    EntityManager manager;

    /**
     * Altera os dados do objeto com o codigo igual ao parâmetro.
     *
     * @param d
     * @return
     */
    public boolean alterar(Disciplina d) {
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    public Disciplina buscarPorCodigo(int cod) {
        manager = JpaUtil.getEntityManager();
        Disciplina disciplina = manager.find(Disciplina.class, cod);
        manager.close();
        return disciplina;
    }
    
    public Disciplina buscarPorNome(String nome) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        Aluno a = (Aluno) session.getAttribute("usuarioLogado");
        manager = JpaUtil.getEntityManager();
        TypedQuery<Disciplina> query = manager.createNamedQuery("Disciplina.findByNome", Disciplina.class);
        query.setParameter("cod", a.getCodigo());
        query.setParameter("nome", nome);
        try {
            if (query.getSingleResult()!= null) {
                return query.getSingleResult();
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public boolean excluir(Disciplina disciplina) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        // recupera a referência ao objeto
        Disciplina temp = manager.find(Disciplina.class, disciplina.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }

    public boolean inserir(Disciplina disciplina) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(disciplina);
        tx.commit();
        manager.close();
        return true;
    }

    public List<Disciplina> listarDisciplinasAluno() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        Aluno a = (Aluno) session.getAttribute("usuarioLogado");
        manager = JpaUtil.getEntityManager();
        TypedQuery<Disciplina> query = manager.createNamedQuery("Disciplina.findByAluno", Disciplina.class);
        query.setParameter("cod", a.getCodigo());
        try {
            if (query.getResultList() != null) {
                return query.getResultList();
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        }
    }
}
