package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Turma;
import util.JpaUtil;

public class TurmaDao implements Serializable {

    EntityManager manager;

    public boolean inserir(Turma turma) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(turma);
        tx.commit();
        manager.close();
        return true;
    }

}
