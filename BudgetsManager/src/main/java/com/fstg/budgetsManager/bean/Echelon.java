package com.fstg.budgetsManager.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Echelon implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private int numero; //actuelle exhelon d'un personnel
	@ManyToOne
	private Echelon echelonNext;
	@ManyToOne
	private Echelon echelonPrevious;
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private Grade grade;
	private int minMois;


}
