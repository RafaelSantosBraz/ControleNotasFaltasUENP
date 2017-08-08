package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Curso;
import util.JpaUtil;

public class CursoDao implements Serializable {

    EntityManager manager;

    public boolean inserir(Curso curso) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(curso);
        tx.commit();
        manager.close();
        return true;
    }

}
