package com.fstg.budgetsManager.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Grade implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;

	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Echelon echelonMax;
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Echelon echelonMin;
	
	@OneToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Grade gradeNext;
	
	@OneToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Grade gradePrevious;
	
	public Grade() {
		super();
	}
	
	
	
	public Grade getGradeNext() {
		return gradeNext;
	}

	public void setGradeNext(Grade gradeNext) {
		this.gradeNext = gradeNext;
	}

	public Grade getGradePrevious() {
		return gradePrevious;
	}

	public void setGradePrevious(Grade gradePrevious) {
		this.gradePrevious = gradePrevious;
	}


	 
	public Echelon getEchelonMax() {
		return echelonMax;
	}

	public void setEchelonMax(Echelon echelonMax) {
		this.echelonMax = echelonMax;
	}

	public Echelon getEchelonMin() {
		return echelonMin;
	}

	public void setEchelonMin(Echelon echelonMin) {
		this.echelonMin = echelonMin;
	}

	public Grade(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

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
		Grade other = (Grade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

