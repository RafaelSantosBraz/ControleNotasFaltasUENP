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
        Aluno a = (Aluno) session.getAttribute("usuarioLogado");
        disciplina.setAluno(a);
        session.setAttribute("disciplinasLogado", getDisciplinas());
    }

    public void salvarDisciplina() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Cadastrada", null));
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        List<Disciplina> a = (List<Disciplina>) session.getAttribute("disciplinasLogado");
        for (Disciplina d : a) {
            if (d.getNome().equals(disciplina.getNome())) {
                return;
            }
        }
        disciplinaDao.inserir(disciplina);
        disciplinas = disciplinaDao.listarTodos();
        manterDisciplina();
        //disciplinas.add(disciplina);
    }

    public void alterar() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        List<Disciplina> a = (List<Disciplina>) session.getAttribute("disciplinasLogado");
        for (Disciplina d : a) {
            if (disciplina.getAluno().getCodigo() == d.getAluno().getCodigo() && disciplina.getCodigo() == d.getCodigo()) {
                for (Disciplina e : a) {
                    if (e.getNome().equals(disciplina.getNome())) {
                        return;
                    }
                }
                d.setNome(disciplina.getNome());
                disciplinaDao.alterar(d);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Alterada com Sucesso", null));
                break;
            }
        }
    }

    public void preparar(Disciplina ma) {
        disciplina = ma;
    }

    public void excluir(Disciplina ma) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        List<Disciplina> a = (List<Disciplina>) session.getAttribute("disciplinasLogado");
        for (Disciplina d : a) {
            if (ma == d) {
                disciplinaDao.excluir(d);
                disciplinas.remove(d);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Alterada com Sucesso", null));
                break;
            }
        }
    }

    public void alterarCarga() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        List<Disciplina> a = (List<Disciplina>) session.getAttribute("disciplinasLogado");
        for (Disciplina d : a) {
            if (disciplina.getAluno().getCodigo() == d.getAluno().getCodigo() && disciplina.getCodigo() == d.getCodigo()) {
                d.setCargaHoraria(disciplina.getCargaHoraria());
                disciplinaDao.alterar(d);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Alterada com Sucesso", null));
                break;
            }
        }
    }

    public void alterarFaltas() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        List<Disciplina> a = (List<Disciplina>) session.getAttribute("disciplinasLogado");
        for (Disciplina d : a) {
            if (disciplina.getAluno().getCodigo() == d.getAluno().getCodigo() && disciplina.getCodigo() == d.getCodigo()) {
                d.setFaltas(disciplina.getFaltas());
                disciplinaDao.alterar(d);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Alterada com Sucesso", null));
                break;
            }
        }
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
