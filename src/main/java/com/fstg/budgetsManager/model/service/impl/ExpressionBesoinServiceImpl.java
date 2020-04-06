package com.fstg.budgetsManager.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fstg.budgetsManager.bean.EntiteAdministrative;
import com.fstg.budgetsManager.bean.ExpressionBesoin;
import com.fstg.budgetsManager.bean.ExpressionBesoinProduit;
import com.fstg.budgetsManager.bean.Personnel;
import com.fstg.budgetsManager.model.dao.ExpressionBesoinDao;
import com.fstg.budgetsManager.model.service.facade.EntiteAdmService;
import com.fstg.budgetsManager.model.service.facade.ExpressionBesoinProduitService;
import com.fstg.budgetsManager.model.service.facade.ExpressionBesoinService;
import com.fstg.budgetsManager.model.service.facade.PersonnelService;

@Service
@Transactional
public class ExpressionBesoinServiceImpl implements ExpressionBesoinService {
	@Autowired
	private ExpressionBesoinDao expbDao;

	@Autowired
	private PersonnelService ps;

	@Autowired
	private EntiteAdmService es;

	@Autowired
	private ExpressionBesoinProduitService ebps;

	@Override
	public int saveEb(ExpressionBesoin expb) {

		/* get The Personnel */
		Personnel chefBD = ps.findByCin(expb.getPersonnel().getCin());

		// get The List Of Product - Test There Existing & Save EBP
		List<ExpressionBesoinProduit> exbProduit = expb.getEbp();

		if (chefBD == null) {
			// Personnel Doesn't exist
			return -1;
		} else {
			EntiteAdministrative enAdBD = es.findByLibelle(chefBD.getEntiteAdm().getLibelle());
			if (!expb.getEntiteAdministrative().getLibelle().equals(enAdBD.getLibelle())) {
				return -2;
			} else {
				expb.setSaveDate(new Date());
				expb.setPersonnel(chefBD);
				expb.setEntiteAdministrative(enAdBD);
				expbDao.save(expb);
				ebps.valideAndsaveEBP(exbProduit, expb);
				return 1;
			}

		}

	}

	@Override
	public int updateEb(ExpressionBesoin expb) {
		/* get The Personnel */
		Personnel chefBD = ps.findByCin(expb.getPersonnel().getCin());

		// get The List Of Product - Test There Existing & Save EBP
		List<ExpressionBesoinProduit> exbProduit = expb.getEbp();

		if (chefBD == null) {
			// Personnel Doesn't exist
			return -1;
		} else {
			EntiteAdministrative enAdBD = es.findByLibelle(chefBD.getEntiteAdm().getLibelle());
			if (!expb.getEntiteAdministrative().getLibelle().equals(enAdBD.getLibelle())) {
				return -2;
			} else {
				expb.setLastUpDate(new Date());
				calculerMontant(expb, exbProduit);
				expbDao.save(expb);
				ebps.valideAndsaveEBP(exbProduit, expb);
				return 1;

			}

		}
	}

	private void calculerMontant(ExpressionBesoin expb, List<ExpressionBesoinProduit> exbProduit) {
		double m = 0;
		for (ExpressionBesoinProduit expressionBesoinProduit : exbProduit) {
			m = m + (expressionBesoinProduit.getQteAccorde() * expressionBesoinProduit.getProduit().getPrice());
		}
		expb.setMontantTotal(m);
	}

	@Override
	public int deleteById(Long id) {
		int res = ebps.deleteByEbId(id);
		expbDao.deleteById(id);
		return res;
	}

	public boolean testInfo(Personnel p, EntiteAdministrative e) {
		return true;
	}

	@Override
	public List<ExpressionBesoin> getAllExpB() {
		return expbDao.findAll();
	}

	@Override
	public List<ExpressionBesoin> getByEntiteAdministrativeLibelle(String libelle) {
		return expbDao.findByEntiteAdministrativeLibelle(libelle);
	}

	@Override
	public List<ExpressionBesoin> getByPersonnelCin(String cin) {
		return expbDao.findByPersonnelCin(cin);
	}

	@Override
	public List<ExpressionBesoin> getBySaveDate(Date saveDate) {
		return expbDao.findBySaveDate(saveDate);
	}
}
