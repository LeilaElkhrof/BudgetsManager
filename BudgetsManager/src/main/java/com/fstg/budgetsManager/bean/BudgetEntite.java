package com.fstg.budgetsManager.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
public class BudgetEntite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "budget_id")
    private Budget budget;
	
	@ManyToOne
	@JoinColumn(name = "entite_id")
	private EntiteAdministrative entite;
	
	private String reference;
	private double montantInv;
	private double montantFonct;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Budget getBudget() {
		return budget;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	public EntiteAdministrative getEntite() {
		return entite;
	}
	public void setEntite(EntiteAdministrative entite) {
		this.entite = entite;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public double getMontantInv() {
		return montantInv;
	}
	public void setMontantInv(double montantInv) {
		this.montantInv = montantInv;
	}
	public double getMontantFonct() {
		return montantFonct;
	}
	public void setMontantFonct(double montantFonct) {
		this.montantFonct = montantFonct;
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
		BudgetEntite other = (BudgetEntite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public BudgetEntite() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
