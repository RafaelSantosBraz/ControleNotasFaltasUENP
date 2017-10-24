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
import javax.faces.context.FacesContext;
import modelo.Disciplina;

/**
 *
 * @author a120121
 */
@ManagedBean(name = "disciplinaControle")
@ViewScoped
public class DisciplinaControle implements Serializable {
    
    private boolean exibirFormAlteraNome;
    private boolean exibirFormAlteraCarga;
    private boolean exibirFormAlteraFaltas;
    private Disciplina disciplinaTemp;
    private DisciplinaDao disciplinaDao;
    private List<Disciplina> disciplinas;
  
    public DisciplinaControle() {
        exibirFormAlteraNome = false;
        exibirFormAlteraCarga = false;
        exibirFormAlteraNome = false;
        disciplinaDao = new DisciplinaDao();
        disciplinas = disciplinaDao.listarDisciplinasAluno();
    }

    public void salvarDisciplina(String nome, int carga, int faltas) {
        Disciplina d = new Disciplina(nome, carga, faltas);
        if (disciplinas.contains(d)) {
            return;
        }
        disciplinaDao.inserir(d);
        disciplinas = disciplinaDao.listarDisciplinasAluno();
    }

    public void alterarNome(String nome) {
        if (disciplinaDao.buscarPorNome(nome) == null) {
            disciplinaTemp.setNome(nome);
            disciplinaDao.alterar(disciplinaTemp);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Alterada com Sucesso", null));
        }
    }

    public void excluir(Disciplina d) {
        disciplinaDao.excluir(d);
        disciplinas.remove(d);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina Removida com Sucesso", null));
    }

    public void alterarCarga(int carga) {
        disciplinaTemp.setCargaHoraria(carga);
        disciplinaDao.alterar(disciplinaTemp);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carga Alterada com Sucesso", null));
    }

    public void alterarFaltas(int faltas) {
        disciplinaTemp.setFaltas(faltas);
        disciplinaDao.alterar(disciplinaTemp);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Faltas Alterada com Sucesso", null));
    }
    
    public void exibirPopUpNome(Disciplina d){
        setDisciplinaTemp(d);
        setExibirFormAlteraNome(true);
    }
    
    public void exibirPopUpCarga(Disciplina d){
        setDisciplinaTemp(d);
        setExibirFormAlteraCarga(true);
    }
    
    public void exibirPopUpFaltas(Disciplina d){
        setDisciplinaTemp(d);
        setExibirFormAlteraFaltas(true);
    }
            
    public boolean isExibirFormAlteraNome() {
        return exibirFormAlteraNome;
    }

    public void setExibirFormAlteraNome(boolean exibirFormAlteraNome) {
        this.exibirFormAlteraNome = exibirFormAlteraNome;
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

    public boolean isExibirFormAlteraCarga() {
        return exibirFormAlteraCarga;
    }

    public void setExibirFormAlteraCarga(boolean exibirFormAlteraCarga) {
        this.exibirFormAlteraCarga = exibirFormAlteraCarga;
    }

    public boolean isExibirFormAlteraFaltas() {
        return exibirFormAlteraFaltas;
    }

    public void setExibirFormAlteraFaltas(boolean exibirFormAlteraFaltas) {
        this.exibirFormAlteraFaltas = exibirFormAlteraFaltas;
    }
    
    
}
