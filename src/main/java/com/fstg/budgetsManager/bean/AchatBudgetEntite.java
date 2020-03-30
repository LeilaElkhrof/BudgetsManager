package com.fstg.budgetsManager.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity

public class AchatBudgetEntite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private BudgetEntite budgetEntite;
	@ManyToOne
	private Achat achat;
	
	public AchatBudgetEntite(Long id, BudgetEntite budgetEntite, Achat achat) {
		super();
		this.id = id;
		this.budgetEntite = budgetEntite;
		this.achat = achat;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BudgetEntite getBudgetEntite() {
		return budgetEntite;
	}
	public void setBudgetEntite(BudgetEntite budgetEntite) {
		this.budgetEntite = budgetEntite;
	}
	public Achat getAchat() {
		return achat;
	}
	public void setAchat(Achat achat) {
		this.achat = achat;
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
		AchatBudgetEntite other = (AchatBudgetEntite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public AchatBudgetEntite() {
		
	}
	

	
}
