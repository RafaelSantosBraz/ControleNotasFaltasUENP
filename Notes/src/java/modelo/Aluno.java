/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author a120121
 */
@Entity
@Table(name = "aluno") // nome da tabela
@NamedQueries({
    @NamedQuery(name = "Aluno.findByCpf", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Aluno.login", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf and a.senha = :senha")
})
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(length = 11, name = "cpf")
    private String cpf;

    @Column(length = 50, name = "nome")
    private String nome;

    @Column(length = 16, name = "senha")
    private String senha;

    public Aluno() {
        this.codigo = 0;
        this.cpf = "";
        this.nome = "";
        this.senha = "";
    }
    
    public Aluno(String nome, String cpf, String senha) {
        this.codigo = 0;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigo);
        hash = 41 * hash + Objects.hashCode(this.cpf);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Aluno{" + "codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome + ", senha=" + senha + '}';
    }

}
