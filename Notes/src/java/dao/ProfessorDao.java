package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Professor;
import util.JpaUtil;

public class ProfessorDao implements Serializable {

    EntityManager manager;

    public boolean inserir(Professor professor) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(professor);
        tx.commit();
        manager.close();
        return true;
    }

}
