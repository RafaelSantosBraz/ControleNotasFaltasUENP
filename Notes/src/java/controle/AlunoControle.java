/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AlunoDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Aluno;

/**
 *
 * @author a120121
 */
@ManagedBean(name = "alunoControle")
@ViewScoped
public class AlunoControle implements Serializable {

    private Aluno aluno;
    private Aluno alunoTemp;
    private AlunoDao alunoDao;
    private List<Aluno> alunos;

    public AlunoControle() {
        aluno = new Aluno();
        alunoTemp = new Aluno();
        alunoDao = new AlunoDao();
        alunos = alunoDao.listarTodos();
    }

    public String login() {
        for (Aluno aux : alunos) {
            if (aux.getCpf().equals(alunoTemp.getCpf()) && aux.getSenha().equals(alunoTemp.getSenha())) {
                alunoTemp.setCodigo(aux.getCodigo());
                aluno = alunoTemp;
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Inválida", null));
                ExternalContext ectx = context.getExternalContext();
                HttpSession session = (HttpSession) ectx.getSession(true);
                session.setAttribute("usuarioLogado", getAlunoTemp());                
                return "view.xhtml";
            }
        }
        return null;
    }

    public String salvarAluno() {
        alunoDao.inserir(alunoTemp);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Cadastrado", null));
        alunos.add(alunoTemp);
        alunoTemp = new Aluno();
        return "index.xhtml";
    }

    public String alterar() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        Aluno a = (Aluno) session.getAttribute("usuarioLogado");
        if (!alunoTemp.getNome().isEmpty()) {
            a.setNome(alunoTemp.getNome());
        }
        a.setSenha(alunoTemp.getSenha());
        alunoDao.alterar(a);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Cadastrado com Sucesso", null));
        return "index.xhtml";
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

    public Aluno getAlunoTemp() {
        return alunoTemp;
    }

    public void setAlunoTemp(Aluno alunoTemp) {
        this.alunoTemp = alunoTemp;
    }  

}
