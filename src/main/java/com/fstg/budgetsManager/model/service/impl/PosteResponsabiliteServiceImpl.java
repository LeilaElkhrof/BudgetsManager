package com.fstg.budgetsManager.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.EntiteAdministrative;
import com.fstg.budgetsManager.bean.Personnel;
import com.fstg.budgetsManager.bean.PosteResponsabilite;
import com.fstg.budgetsManager.model.dao.PersonnelDao;
import com.fstg.budgetsManager.model.dao.PosteResponsabiliteDao;
import com.fstg.budgetsManager.model.service.facade.EchelonService;
import com.fstg.budgetsManager.model.service.facade.EntiteAdmService;
import com.fstg.budgetsManager.model.service.facade.PersonnelService;
import com.fstg.budgetsManager.model.service.facade.PosteResponsabiliteService;

@Service
public class PosteResponsabiliteServiceImpl implements PosteResponsabiliteService {

	@Autowired
	PersonnelService personnelService;

	@Autowired
	EchelonService echelonService;

	@Autowired
	EntiteAdmService entiteAdmService;

	@Autowired
	PosteResponsabiliteDao posteResponsabiliteDao;

	@Override
	public List<PosteResponsabilite> findAll() {
		// TODO Auto-generated method stub
		return posteResponsabiliteDao.findAll();
	}

	@Override
	public int save(PosteResponsabilite posteResponsabilite) {
		Personnel foundedPersonnel = personnelService.findByCin(posteResponsabilite.getPersonnel().getCin());
		EntiteAdministrative foundedEntiteAdm = entiteAdmService.findByLibelle(posteResponsabilite.getEntiteAdministrative().getLibelle());
		
		if (foundedPersonnel == null) {
			return -1;
		} else if (foundedEntiteAdm == null) {
			return -2;
		} else {
			posteResponsabiliteDao.save(posteResponsabilite);
			return 1;
		}

	}


}
