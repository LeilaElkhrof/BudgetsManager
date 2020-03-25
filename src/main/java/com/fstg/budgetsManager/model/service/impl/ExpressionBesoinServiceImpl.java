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
	public int createExpB(ExpressionBesoin expb) {

		/* get The Personnel 
		Personnel chefBD = ps.findByCin(expb.getPersonnel().getCin());

		// get The Personnel EntiteAdmin
		EntiteAdministrative enAdBD = es.findByLibelle(chefBD.getEntiteAdm().getLibelle());*/

		// get The List Of Product - Test There Existing & Save EBP
		List<ExpressionBesoinProduit> exbProduit = expb.getEbp();

		/*if (enAdBD == null) {
			// EntiteAdmin Doesn't exist
			return -1;
		}*/
			
			expb.setDateExpressionBessoin(new Date());
			expbDao.save(expb);
			ebps.valideAndsaveEBP(exbProduit, expb);
			return 1;

	}

	@Override
	public List<ExpressionBesoin> getAllExpB() {
		return expbDao.findAll();
	}

	/* Expression Du Besoin D'une Entité Administrative */
	@Override
	public List<ExpressionBesoin> getByEntiteAdministrativeLibelle(String libelle) {
		return expbDao.findByEntiteAdministrativeLibelle(libelle);
	}

	@Override
	public int deleteById(Long id) {
		int res=ebps.deleteByEbId(id);
		expbDao.deleteById(id);
		return res;
	}

}
