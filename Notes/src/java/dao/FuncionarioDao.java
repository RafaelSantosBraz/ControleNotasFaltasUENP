package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Funcionario;
import util.JpaUtil;

public class FuncionarioDao implements Serializable {

    EntityManager manager;

    public boolean inserir(Funcionario funcionario) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(funcionario);
        tx.commit();
        manager.close();
        return true;
    }

}
