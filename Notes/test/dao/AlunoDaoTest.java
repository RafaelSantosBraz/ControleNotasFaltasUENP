/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Aluno;
import modelo.Disciplina;
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

    @Test
    public void testSomeMethod() {
        Aluno d = new Aluno();
        d.setNome("Juriscleison");
        Disciplina dis = new Disciplina();
        dis.setNome("Magic");
        new AlunoDao().inserir(d);
    }
    
}
