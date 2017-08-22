package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Avaliacao;
import util.JpaUtil;

public class AvaliacaoDao implements Serializable {

    EntityManager manager;

    public boolean inserir(Avaliacao avaliacao) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(avaliacao);
        tx.commit();
        manager.close();
        return true;
    }

}
