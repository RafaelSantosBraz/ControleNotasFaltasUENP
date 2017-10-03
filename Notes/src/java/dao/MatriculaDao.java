package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Aluno;
import modelo.Matricula;
import util.JpaUtil;

public class MatriculaDao implements Serializable {

    EntityManager manager;

    /**
     * Altera os dados do objeto com o codigo igual ao parâmetro.
     *
     * @param a
     * @return
     */
    public boolean alterar(Matricula a) {
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(a);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    public Matricula buscarPorCodigo(int cod) {
        manager = JpaUtil.getEntityManager();
        Matricula Matricula = manager.find(Matricula.class, cod);
        manager.close();
        return Matricula;
    }

    public List<Matricula> buscarPorAluno(Aluno cod) {
        manager = JpaUtil.getEntityManager();
        TypedQuery<Matricula> query = manager.createNamedQuery("Matricula.findByAluno", Matricula.class);
        query.setParameter("cod", cod);
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

    public boolean excluir(Matricula Matricula) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        // recupera a referência ao objeto
        Matricula temp = manager.find(Matricula.class, Matricula.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }

    public boolean inserir(Matricula Matricula) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(Matricula);
        tx.commit();
        manager.close();
        return true;
    }

    public List<Matricula> listarTodos() {
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<Matricula> query = manager.getCriteriaBuilder().createQuery(Matricula.class);
        query.select(query.from(Matricula.class));
        List<Matricula> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }

}
