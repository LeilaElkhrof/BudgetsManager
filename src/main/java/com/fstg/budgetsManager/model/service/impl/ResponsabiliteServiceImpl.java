package com.fstg.budgetsManager.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.Responsabilite;
import com.fstg.budgetsManager.model.dao.ResponsabiliteDao;
import com.fstg.budgetsManager.model.service.facade.ResponsabiliteService;

@Service
public class ResponsabiliteServiceImpl implements ResponsabiliteService {
	
	@Autowired
	private ResponsabiliteDao responsabiliteDao;

	@Override
	public List<Responsabilite> findAll() {

		return responsabiliteDao.findAll();
	}

	@Override
	public Responsabilite findByLibelle(String libelle) {

		return responsabiliteDao.findByLibelle(libelle);
	}

	@Override
	public int save (Responsabilite responsabilite) {
		Responsabilite foundedResponsabilite = findByLibelle(responsabilite.getLibelle());
		if (foundedResponsabilite != null) {
			return -1;
		}else {
			responsabiliteDao.save(responsabilite);
			return 1;
		}
	}
}
