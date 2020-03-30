package com.fstg.budgetsManager.model.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.CompteComptable;
import com.fstg.budgetsManager.model.dao.CompteComptableDao;
import com.fstg.budgetsManager.model.service.facade.CompteComptableService;



@Service
public class CompteComptableServiceImpl implements CompteComptableService {
	@Autowired
	private CompteComptableDao compteComptableDao;

	@Override
	public CompteComptable findByLibelle(String libelle) {
		return compteComptableDao.findByLibelle(libelle);
	}

	@Override
	public int save(CompteComptable compteComptable) {
		CompteComptable compteComptableFound=findByLibelle(compteComptable.getLibelle());
		if(compteComptableFound!=null) {
			return -1;
		}else {
			compteComptableDao.save(compteComptable);
			return 1;
		}
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		int delCompte=deleteByLibelle(libelle);
		return delCompte;
	}
	
}
