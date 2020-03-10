package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.fstg.budgetsManager.bean.Personnel;

public interface PersonnelService {

	public Personnel findByCin(String cin);
	
	public List<Personnel> findByEchelonLibelle (String libelle);

	public int save(Personnel personnel);

	public List<Personnel> findAll();
	
	public List<Personnel> findByEntiteAdmLibelle(String libelle);

	public List<Personnel> findGrandSalaire(@Param(value = "valeur") double valeur);
    public List<Personnel> findPetitSalaire(@Param(value = "valeur") double valeur);

    public int transfert(String cin);
}