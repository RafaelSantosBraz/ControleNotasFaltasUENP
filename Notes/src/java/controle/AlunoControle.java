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

    private AlunoDao alunoDao;
    private List<Aluno> alunos;

    public AlunoControle() {
        alunoDao = new AlunoDao();
        alunos = alunoDao.listarTodos();
    }

    public String login(String cpf, String senha) {
        Aluno a = alunoDao.autenticarAluno(cpf, senha);
        if (a != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext ectx = context.getExternalContext();
            HttpSession session = (HttpSession) ectx.getSession(true);
            session.setAttribute("usuarioLogado", a);
            return "paginaPrincipal.xhtml";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Inválida", null));
        return null;
    }

    public String salvarAluno(String nome, String cpf, String senha) {
        Aluno a = new Aluno(nome, cpf, senha);
        alunoDao.inserir(a);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Cadastrado", null));
        alunos.add(a);
        return "index.xhtml";
    }

    public String alterarNomeSenha(String nome, String senha) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        Aluno a = (Aluno) session.getAttribute("usuarioLogado");
        if ("".equals(senha) && "".equals(nome)) {
            return null;
        }
        if (!"".equals(nome) && "".equals(senha)) {
            a.setNome(nome);
        }
        if ("".equals(nome) && !"".equals(senha)) {
            a.setSenha(senha);
        }
        if (!"".equals(nome) && !"".equals(senha)) {
            a.setNome(nome);
            a.setSenha(senha);
        }
        alunoDao.alterar(a);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados Alterados com Sucesso", null));
        return "paginaPrincipal.xhtml";
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
