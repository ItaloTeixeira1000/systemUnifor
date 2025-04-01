package com.unifor.system.models;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aluno")
public class Aluno {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String nome;

	    @Column(name = "matricula")
	    private String matricula;

	    private String email;

	    @Column(name = "data_nascimento")
	    @Temporal(TemporalType.DATE)
	    private Calendar dataNascimento;

	    private String telefone;

	    @ManyToMany
	    private List<Curso> cursos;
}
