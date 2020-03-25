package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.EntiteAdministrative;

public interface EntiteAdmService {

	public EntiteAdministrative findByLibelle(String libelle);
	public List<EntiteAdministrative> findAll();
	public int save(EntiteAdministrative entite);
	public int deleteByLibelle(String libelle);
}
