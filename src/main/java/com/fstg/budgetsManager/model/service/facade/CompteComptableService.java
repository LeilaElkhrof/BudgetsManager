package com.fstg.budgetsManager.model.service.facade;

import com.fstg.budgetsManager.bean.CompteComptable;

public interface CompteComptableService {
	public CompteComptable findByLibelle(String libelle);
	public int save(CompteComptable compteComptable);
	public int deleteByLibelle(String libelle);
}
