package com.fstg.budgetsManager.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fstg.budgetsManager.bean.EntiteAdministrative;
import com.fstg.budgetsManager.model.dao.EntiteAdministrativeDao;
import com.fstg.budgetsManager.model.service.facade.EntiteAdmService;

@Service
public class EntiteAdmServiceImpl implements EntiteAdmService {

	@Autowired
	private EntiteAdministrativeDao entiteAdmDao;
	
	@Override
	public EntiteAdministrative findByLibelle(String libelle) {
		return entiteAdmDao.findByLibelle(libelle);
	}

	@Override
	public List<EntiteAdministrative> findAll() {
		return entiteAdmDao.findAll();
	}

	
	@Override
	public int save(EntiteAdministrative entite) {
     EntiteAdministrative foundedEntite = findByLibelle(entite.getLibelle());
    
     if(foundedEntite != null)
		return -1;
 
     else {
    	 entiteAdmDao.save(entite);
     return 1;
     }
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return entiteAdmDao.deleteByLibelle(libelle);
	}

	


	

}
