/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author a120121
 */
@Entity
@Table(name = "turma") // nome da tabela

public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "ano")
    private Integer ano;

    @Column(length = 50, name = "nome")
    private String nome;

    @Column(name = "disicplinasPadrao")
    private ArrayList<Disciplina> disiciplinasPadrao;

    public Turma() {
        this.codigo = 0;
        this.ano = 0;
        this.nome = "";
        disiciplinasPadrao = null;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public ArrayList<Disciplina> getDisiciplinasPadrao() {
        return disiciplinasPadrao;
    }

    public void setDisiciplinasPadrao(ArrayList<Disciplina> disiciplinasPadrao) {
        this.disiciplinasPadrao = disiciplinasPadrao;
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
        hash = 43 * hash + Objects.hashCode(this.codigo);
        hash = 43 * hash + Objects.hashCode(this.ano);
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.disiciplinasPadrao);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.disiciplinasPadrao, other.disiciplinasPadrao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Turma{" + "codigo=" + codigo + ", ano=" + ano + ", nome=" + nome + ", disiciplinasPadrao=" + disiciplinasPadrao + '}';
    }

}
