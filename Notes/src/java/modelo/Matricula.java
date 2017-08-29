/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author a120120
 */

@Entity
@Table(name = "matricula")

public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @ManyToOne(optional=false, cascade = CascadeType.MERGE ) // permite atualizar aluno se mudar o campo aluno do objeto membroAluno
    @JoinColumn(name="codigo")
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "iddisciplina")
    private Disciplina disciplina;

    @Column(name = "faltas")
    private Integer faltas;
    
}
