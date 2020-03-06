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


}
