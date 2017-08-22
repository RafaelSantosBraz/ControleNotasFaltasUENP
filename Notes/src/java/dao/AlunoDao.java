package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Aluno;
import util.JpaUtil;

public class AlunoDao implements Serializable {

    EntityManager manager;

    public boolean inserir(Aluno aluno) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(aluno);
        tx.commit();
        manager.close();
        return true;
    }

}
