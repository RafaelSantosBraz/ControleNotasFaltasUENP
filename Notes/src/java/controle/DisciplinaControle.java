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
        manterDisciplina();
    }

    public void manterDisciplina() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        session.setAttribute("disciplinasLogado", getDisciplina());
    }

    public void salvarDisciplina() {
        disciplinaDao.inserir(disciplina);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Cadastrada", null));
        disciplinas.add(disciplina);
        disciplina = new Disciplina();
    }

    public void alterar() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        Disciplina a = (Disciplina) session.getAttribute("disciplinasLogado");
        a.setNome(disciplina.getNome());
        a.setFaltas(disciplina.getFaltas());
        disciplinaDao.alterar(a);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Cadastrada com Sucesso", null));
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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

}
