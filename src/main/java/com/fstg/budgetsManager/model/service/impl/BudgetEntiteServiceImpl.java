package com.fstg.budgetsManager.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.Budget;
import com.fstg.budgetsManager.bean.BudgetEntite;
import com.fstg.budgetsManager.bean.EntiteAdministrative;
import com.fstg.budgetsManager.model.dao.BudgetEntiteDao;
import com.fstg.budgetsManager.model.service.facade.BudgetEntiteService;
import com.fstg.budgetsManager.model.service.facade.BudgetService;
import com.fstg.budgetsManager.model.service.facade.EntiteAdmService;

@Service
public class BudgetEntiteServiceImpl implements BudgetEntiteService {

	@Autowired
	BudgetEntiteDao budgetEntiteDao;
	@Autowired
	BudgetService budgetService;
	@Autowired
	EntiteAdmService entiteService;

	@Override
	public List<BudgetEntite> findAll() {
		return budgetEntiteDao.findAll();
	}

	@Override
	public List<BudgetEntite> findByBudgetReference(String reference) {
		return budgetEntiteDao.findByBudgetReference(reference);
	}

	@Override
	public BudgetEntite findByReference(String reference) {
		return budgetEntiteDao.findByReference(reference);
	}

	@Override
	public List<BudgetEntite> findByEntiteLibelle(String libelle) {
		return budgetEntiteDao.findByEntiteLibelle(libelle);
	}

	public boolean validateBudgetEntites(Budget budget, List<BudgetEntite> budgetEntites) {
		
		List<BudgetEntite> valideEntites = new ArrayList();
		
		for(BudgetEntite budgetEntite : budgetEntites) {
			if(entiteService.findByLibelle(budgetEntite.getEntite().getLibelle()) != null) {
				valideEntites.add(budgetEntite);
			}
		}
		return valideEntites.size() == budgetEntites.size();
	}

	@Override
	public int save(Budget budget, List<BudgetEntite> budgetEntites) {
		if (validateBudgetEntites(budget, budgetEntites)) {		    
	    	    budgetEntites.forEach(b -> {
				b.setBudget(budget);
				EntiteAdministrative entite = entiteService.findByLibelle(b.getEntite().getLibelle());
				b.setEntite(entite);
				budgetEntiteDao.save(b);
			});
	       return 1;
		} else 
			return -2;
	}

	
}
