/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Aluno;
import modelo.Disciplina;
import modelo.Matricula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a120121
 */
public class AlunoDaoTest {

    public AlunoDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void testMatricular() {
//        Aluno a;
//        a = new AlunoDao().buscarPorCPF("1234567898");
//        Disciplina d;
//        d = new DisciplinaDao().buscarPorCodigo(1);
//        Matricula m = new Matricula();
//        m.setAluno(a);
//        m.setDisciplina(d);
//        m.setFaltas(0);
//        a.getMatriculas().add(m);
//        new AlunoDao().alterar(a);
//    }

    @Test
    public void testeInserir(){
        Aluno a = new Aluno();
        a.setCpf("12312312312");
        a.setSenha("rafael1234");
        a.setNome("Rafael Braz");
        new AlunoDao().inserir(a);
    }
}
