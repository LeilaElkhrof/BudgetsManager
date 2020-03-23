package com.fstg.budgetsManager.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class PosteResponsabilite implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private Personnel personnel;
	private Date dateAffectation;
	private Date dateFin;
	private EntiteAdministrative entiteAdministrative;
	private Echelon echelon;
	private Responsabilite responsabilite;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public EntiteAdministrative getEntiteAdministrative() {
		return entiteAdministrative;
	}
	public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative) {
		this.entiteAdministrative = entiteAdministrative;
	}
	public Echelon getEchelon() {
		return echelon;
	}
	public void setEchelon(Echelon echelon) {
		this.echelon = echelon;
	}
	public Responsabilite getResponsabilite() {
		return responsabilite;
	}
	public void setResponsabilite(Responsabilite responsabilite) {
		this.responsabilite = responsabilite;
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
		PosteResponsabilite other = (PosteResponsabilite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public PosteResponsabilite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
}
