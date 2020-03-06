package com.fstg.budgetsManager.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ExpressionBesoinProduit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Produit produit;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private ExpressionBesoin eb;
	
	private double qteDemande;
	private double qteAccorde;
	private double qteAchete;
	
}
