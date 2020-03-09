package com.fstg.budgetsManager.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

public class Personnel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private double salaire;
	
	@ManyToOne
	@JoinColumn(name = "poste_id")
	private PosteResponsabilite poste;
	
	@ManyToOne 
	@JoinColumn(name = "echelon_id")
	private Echelon echelon;

	@ManyToOne
	@JoinColumn(name = "entite_id")
	private EntiteAdministrative entiteAdm;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateAffectation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public PosteResponsabilite getPoste() {
		return poste;
	}

	public void setPoste(PosteResponsabilite poste) {
		this.poste = poste;
	}

	public Echelon getEchelon() {
		return echelon;
	}

	public void setEchelon(Echelon echelon) {
		this.echelon = echelon;
	}

	public EntiteAdministrative getEntiteAdm() {
		return entiteAdm;
	}

	public void setEntiteAdm(EntiteAdministrative entiteAdm) {
		this.entiteAdm = entiteAdm;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
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
		Personnel other = (Personnel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
