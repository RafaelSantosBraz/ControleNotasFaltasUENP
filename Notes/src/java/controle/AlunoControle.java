/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AlunoDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Aluno;

/**
 *
 * @author a120121
 */
@ManagedBean(name = "alunoControle")
@ViewScoped
public class AlunoControle implements Serializable {

    private Aluno aluno;
    private AlunoDao alunoDao;
    private List<Aluno> alunos;

    public AlunoControle() {
        aluno = new Aluno();
        alunoDao = new AlunoDao();
        alunos = alunoDao.listarTodos();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoDao getAlunoDao() {
        return alunoDao;
    }

    public void setAlunoDao(AlunoDao alunoDao) {
        this.alunoDao = alunoDao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

}
