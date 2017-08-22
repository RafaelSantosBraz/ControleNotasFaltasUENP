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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author a120121
 */
@Entity
@Table(name = "avaliacao") // nome da tabela

public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(length = 50, name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn (name = "disciplina", referencedColumnName = "codigo")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn (name = "aluno", referencedColumnName = "codigo")
    private Aluno aluno;

    @Column(name = "nota")
    private Double nota;

    @Column(name = "peso")
    private Integer peso;

    public Avaliacao() {
        this.codigo = 0;
        this.disciplina = null;
        this.nome = "";
        this.aluno = null;
        this.nota = 0.0;
        this.peso = 100;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
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
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.disciplina);
        hash = 67 * hash + Objects.hashCode(this.aluno);
        hash = 67 * hash + Objects.hashCode(this.nota);
        hash = 67 * hash + Objects.hashCode(this.peso);
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
        final Avaliacao other = (Avaliacao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.nota, other.nota)) {
            return false;
        }
        if (!Objects.equals(this.peso, other.peso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "codigo=" + codigo + ", nome=" + nome + ", disciplina=" + disciplina + ", aluno=" + aluno + ", nota=" + nota + ", peso=" + peso + '}';
    }

}
