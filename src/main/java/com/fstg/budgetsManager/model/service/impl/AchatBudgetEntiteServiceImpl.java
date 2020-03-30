package com.fstg.budgetsManager.model.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.AchatBudgetEntite;
import com.fstg.budgetsManager.bean.BudgetEntite;
import com.fstg.budgetsManager.bean.Produit;
import com.fstg.budgetsManager.bean.ProduitAchat;
import com.fstg.budgetsManager.model.dao.AchatBudgetEntiteDao;
import com.fstg.budgetsManager.model.dao.AchatDao;
import com.fstg.budgetsManager.model.service.facade.AchatBudgetEntiteService;
import com.fstg.budgetsManager.model.service.facade.AchatService;
import com.fstg.budgetsManager.model.service.facade.BudgetEntiteService;
import com.fstg.budgetsManager.model.service.facade.ProduitAchatService;
import com.fstg.budgetsManager.model.service.facade.ProduitService;


@Service
public class AchatBudgetEntiteServiceImpl implements AchatBudgetEntiteService {
	@Autowired
	private AchatBudgetEntiteDao achatBudgetEntiteDao;
	@Autowired
	private BudgetEntiteService budgetEntiteService;

	@Override
	public List<AchatBudgetEntite> findByBudgetEntiteReference(String reference) {
		return achatBudgetEntiteDao.findByBudgetEntiteReference(reference);
	}
	@Override
	public int save(Achat achat, List<AchatBudgetEntite> achatBudgetEntites) {
		for (AchatBudgetEntite achatBudgetEntite : achatBudgetEntites) {
			BudgetEntite budgetEntite = budgetEntiteService.findByReference(achatBudgetEntite.getBudgetEntite().getReference());
		    achatBudgetEntite.setBudgetEntite(budgetEntite);
			achatBudgetEntite.setAchat(achat);
			achatBudgetEntiteDao.save(achatBudgetEntite);
		}
			
			return 1;

	}
	@Override
	public List<AchatBudgetEntite> findByAchatCode(String code) {
		return achatBudgetEntiteDao.findByAchatCode(code);
	}
	
 
}
