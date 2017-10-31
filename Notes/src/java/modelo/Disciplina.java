/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;

/**
 *
 * @author a120121
 */
@Entity
@Table(name = "disciplina") // nome da tabela
@NamedQueries({
    @NamedQuery(name = "Disciplina.findByAluno", query = "SELECT d FROM Disciplina d WHERE d.aluno.codigo = :cod")
    ,
    @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome and d.aluno.codigo = :cod")
})
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(length = 50, name = "nome")
    private String nome;

    @Column(name = "cargaHoraria")
    private Integer cargaHoraria;

    @Column(name = "faltas")
    private Integer faltas;

    @OneToOne
    private Aluno aluno;

    public Disciplina() {
        this.codigo = 0;
        this.cargaHoraria = 0;
        this.nome = "";
        this.faltas = 0;
        this.aluno = null;
    }
    
    public Disciplina(String nome, int carga, int faltas) {
        this.codigo = 0;
        this.cargaHoraria = carga;
        this.nome = nome;
        this.faltas = faltas;
        this.aluno = null;
    }
    
    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHorario) {
        this.cargaHoraria = cargaHorario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.codigo);
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.cargaHoraria);
        hash = 43 * hash + Objects.hashCode(this.faltas);
        hash = 43 * hash + Objects.hashCode(this.aluno);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.cargaHoraria, other.cargaHoraria)) {
            return false;
        }
        if (!Objects.equals(this.faltas, other.faltas)) {
            return false;
        }
        return Objects.equals(this.aluno, other.aluno);
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + ", faltas=" + faltas + ", aluno=" + aluno + '}';
    }

}
