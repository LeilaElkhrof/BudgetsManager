package com.fstg.budgetsManager.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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
		
}
