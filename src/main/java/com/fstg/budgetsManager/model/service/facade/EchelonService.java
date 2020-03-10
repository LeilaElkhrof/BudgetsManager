package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.Echelon;


public interface EchelonService {

	public Echelon findByLibelle(String libelle);

	public int save(Echelon echelon);

	public List<Echelon> findAll();

	public Echelon findByNumero(int numero);
	
	public List<Echelon> findByGradeLibelle(String libelle);
	
}