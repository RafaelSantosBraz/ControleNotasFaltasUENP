/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AlunoDao;
import dao.DisciplinaDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Aluno;
import modelo.Disciplina;

/**
 *
 * @author a120121
 */
@ManagedBean(name = "disciplinaControle")
@ViewScoped
public class DisciplinaControle implements Serializable {

    private Disciplina disciplina;
    private DisciplinaDao disciplinaDao;
    private List<Disciplina> disciplinas;

    public DisciplinaControle() {
        disciplina = new Disciplina();
        disciplinaDao = new DisciplinaDao();
        disciplinas = disciplinaDao.listarTodos();
    }
    
    public void criarDisciplina(){
        
    }
    
    public void alterarDisciplina(){
        
    }
    
    public void excluirDisciplina(){
        
    }

}