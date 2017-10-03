/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author a120120
 */
@Entity
@Table(name = "matricula")
@NamedQueries({
    @NamedQuery(name = "Matricula.findByAluno", query = "SELECT u FROM Matricula u WHERE u.aluno = :cod")
})

public class Matricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE) // permite atualizar aluno se mudar o campo aluno do objeto membroAluno
    @JoinColumn(name = "aluno", referencedColumnName = "codigo")
    private Aluno aluno;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "disciplina", referencedColumnName = "codigo")
    private Disciplina disciplina;

    @Column(name = "faltas")
    private Integer faltas;

    public Matricula() {
        faltas = 0;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.codigo);
        hash = 83 * hash + Objects.hashCode(this.aluno);
        hash = 83 * hash + Objects.hashCode(this.disciplina);
        hash = 83 * hash + Objects.hashCode(this.faltas);
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
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.faltas, other.faltas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codigo=" + codigo + ", aluno=" + aluno + ", disciplina=" + disciplina + ", faltas=" + faltas + '}';
    }

}
