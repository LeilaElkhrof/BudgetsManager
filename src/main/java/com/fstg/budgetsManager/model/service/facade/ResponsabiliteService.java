package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.Responsabilite;

public interface ResponsabiliteService {
	
	public List<Responsabilite> findAll();

	public Responsabilite findByLibelle(String libelle);

	public int save(Responsabilite responsabilite);
}
