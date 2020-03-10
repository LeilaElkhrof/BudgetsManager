package com.fstg.budgetsManager.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Budget implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String reference;
	private double montantInv;
	private double montantFonct;
	private double creditOuvert;
	private int annee;
	
	@OneToMany(mappedBy="budget")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<BudgetEntite> budgetEntites;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getCreditOuvert() {
		return creditOuvert;
	}

	public void setCreditOuvert(double creditOuvert) {
		this.creditOuvert = creditOuvert;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public List<BudgetEntite> getBudgetEntites() {
		return budgetEntites;
	}

	public void setBudgetEntites(List<BudgetEntite> budgetEntites) {
		this.budgetEntites = budgetEntites;
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
		Budget other = (Budget) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Budget() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}
