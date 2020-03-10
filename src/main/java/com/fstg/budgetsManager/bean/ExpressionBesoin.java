package com.fstg.budgetsManager.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class ExpressionBesoin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dateExpressionBessoin;
	
	private Personnel personnel;
	
	@ManyToOne
	private EntiteAdministrative entiteAdministrative;
	
	@OneToMany(mappedBy = "eb") 
	private List<ExpressionBesoinProduit> ebp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateExpressionBessoin() {
		return dateExpressionBessoin;
	}

	public void setDateExpressionBessoin(Date dateExpressionBessoin) {
		this.dateExpressionBessoin = dateExpressionBessoin;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public EntiteAdministrative getEntiteAdministrative() {
		return entiteAdministrative;
	}

	public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative) {
		this.entiteAdministrative = entiteAdministrative;
	}

	public List<ExpressionBesoinProduit> getEbp() {
		return ebp;
	}

	public void setEbp(List<ExpressionBesoinProduit> ebp) {
		this.ebp = ebp;
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
		ExpressionBesoin other = (ExpressionBesoin) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public ExpressionBesoin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}