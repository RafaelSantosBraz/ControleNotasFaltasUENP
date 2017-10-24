package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Aluno;
import util.JpaUtil;

public class AlunoDao implements Serializable {

    EntityManager manager;

    /**
     * Altera os dados do objeto com o codigo igual ao parâmetro.
     *
     * @param a
     * @return
     */
    public boolean alterar(Aluno a) {
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(a);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    public Aluno buscarPorCodigo(int cod) {
        manager = JpaUtil.getEntityManager();
        Aluno aluno = manager.find(Aluno.class, cod);
        manager.close();
        return aluno;
    }

    public Aluno buscarPorCPF(String cpf) {
        manager = JpaUtil.getEntityManager();
        TypedQuery<Aluno> query = manager.createNamedQuery("Aluno.findByCpf", Aluno.class);
        query.setParameter("cpf", cpf);
        try {
            if (query.getSingleResult() != null) {
                return query.getSingleResult();
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Aluno autenticarAluno(String cpf, String senha) {
        manager = JpaUtil.getEntityManager();
        TypedQuery<Aluno> query = manager.createNamedQuery("Aluno.login", Aluno.class);
        query.setParameter("cpf", cpf);
        query.setParameter("senha", senha);
        try {
            if (query.getSingleResult() != null) {
                return query.getSingleResult();
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public boolean excluir(Aluno aluno) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        // recupera a referência ao objeto
        Aluno temp = manager.find(Aluno.class, aluno.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }

    public boolean inserir(Aluno aluno) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(aluno);
        tx.commit();
        manager.close();
        return true;
    }

    public List<Aluno> listarTodos() {
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<Aluno> query = manager.getCriteriaBuilder().createQuery(Aluno.class);
        query.select(query.from(Aluno.class));
        List<Aluno> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }

}
