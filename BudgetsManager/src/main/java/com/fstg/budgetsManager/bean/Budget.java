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
@Data
@NoArgsConstructor
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
	

	
	
}
