/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DisciplinaDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Aluno;
import modelo.Disciplina;

/**
 *
 * @author a120121
 */
@ManagedBean(name = "disciplinaControle")
@ViewScoped
public class DisciplinaControle implements Serializable {
    
    private boolean exibirFormAltera;   
    private Disciplina disciplinaTemp;
    private DisciplinaDao disciplinaDao;
    private List<Disciplina> disciplinas;
  
    public DisciplinaControle() {
        exibirFormAltera = false;
        disciplinaDao = new DisciplinaDao();
        disciplinas = disciplinaDao.listarDisciplinasAluno();
    }

    public void salvarDisciplina(String nome, int carga, int faltas) {
        Disciplina d = new Disciplina(nome, carga, faltas);
        if (disciplinaDao.buscarPorNome(nome) != null) {
            return;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        d.setAluno((Aluno) session.getAttribute("usuarioLogado"));
        disciplinaDao.inserir(d);
        disciplinas = disciplinaDao.listarDisciplinasAluno();
    }

    public void alterar() {
            disciplinaDao.alterar(disciplinaTemp);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Alterada com Sucesso", null));
            this.exibirFormAltera = false;
    }

    public void excluir(Disciplina d) {
        disciplinaDao.excluir(d);
        disciplinas.remove(d);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Removida com Sucesso", null));
    }
    
    public void exibirPopUp(Disciplina d){
        setDisciplinaTemp(d);
        setExibirFormAltera(true);
    }
    
    public Disciplina getDisciplinaTemp() {
        return disciplinaTemp;
    }

    public void setDisciplinaTemp(Disciplina disciplinaTemp) {
        this.disciplinaTemp = disciplinaTemp;
    }

    public DisciplinaDao getDisciplinaDao() {
        return disciplinaDao;
    }

    public void setDisciplinaDao(DisciplinaDao disciplinaDao) {
        this.disciplinaDao = disciplinaDao;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public boolean isExibirFormAltera() {
        return exibirFormAltera;
    }

    public void setExibirFormAltera(boolean exibirFormAltera) {
        this.exibirFormAltera = exibirFormAltera;
    }
    
    
}
