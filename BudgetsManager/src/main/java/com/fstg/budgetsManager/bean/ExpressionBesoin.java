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
@Data
@NoArgsConstructor
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
	
	@ManyToOne
	private Personnel personnel;
	
	@ManyToOne
	private EntiteAdministrative entiteAdministrative;
	
	@OneToMany(mappedBy = "eb") 
	private List<ExpressionBesoinProduit> ebp;
}
