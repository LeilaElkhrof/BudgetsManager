package com.fstg.budgetsManager.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ExpressionBesoin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Temporal(TemporalType.DATE)
	private Date saveDate;
	
	@Temporal(TemporalType.DATE)
	private Date lastUpDate;
	
	@ManyToOne
	@JoinColumn(name="personnel_Id")
	private Personnel personnel;
	
	@ManyToOne
	private EntiteAdministrative entiteAdministrative;
	
	@OneToMany(mappedBy = "eb") 
	private List<ExpressionBesoinProduit> ebp;
	
	private double montantTotal;
	
	private String stat;
	
	public ExpressionBesoin() {
		
	}
	

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
	
	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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
	

	public Date getSaveDate() {
		return saveDate;
	}


	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}


	public Date getLastUpDate() {
		return lastUpDate;
	}


	public void setLastUpDate(Date lastUpDate) {
		this.lastUpDate = lastUpDate;
	}
	


	public double getMontantTotal() {
		return montantTotal;
	}


	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}
	
	
	


	public String getStat() {
		return stat;
	}


	public void setStat(String stat) {
		this.stat = stat;
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

	
	
}
