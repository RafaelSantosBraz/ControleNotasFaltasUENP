package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Disciplina;
import util.JpaUtil;

public class DisciplinaDao implements Serializable {

    EntityManager manager;

    public boolean inserir(Disciplina disciplina) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(disciplina);
        tx.commit();
        manager.close();
        return true;
    }

}
