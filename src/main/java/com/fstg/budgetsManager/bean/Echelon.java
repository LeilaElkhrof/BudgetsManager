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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Echelon getEchelonNext() {
		return echelonNext;
	}
	public void setEchelonNext(Echelon echelonNext) {
		this.echelonNext = echelonNext;
	}
	public Echelon getEchelonPrevious() {
		return echelonPrevious;
	}
	public void setEchelonPrevious(Echelon echelonPrevious) {
		this.echelonPrevious = echelonPrevious;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public int getMinMois() {
		return minMois;
	}
	public void setMinMois(int minMois) {
		this.minMois = minMois;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Echelon other = (Echelon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Echelon() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
