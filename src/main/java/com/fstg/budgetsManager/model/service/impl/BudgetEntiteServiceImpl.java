package com.fstg.budgetsManager.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public List<BudgetEntite> validateBudgetEntites(List<BudgetEntite> budgetEntites) {

		List<BudgetEntite> valideEntites = new ArrayList<BudgetEntite>();
		
		for(BudgetEntite budgetEntite : budgetEntites) {
			if(entiteService.findByLibelle(budgetEntite.getEntite().getLibelle()) != null) {
				valideEntites.add(budgetEntite);
			}
		}
		return valideEntites;
	}

	@Override
	public int save(Budget budget, List<BudgetEntite> budgetEntites) {
		List<BudgetEntite> valideEntites = validateBudgetEntites(budgetEntites);
		if (valideEntites != null) {		    
			for(BudgetEntite valideEntite : valideEntites) {
				valideEntite.setBudget(budget);
				EntiteAdministrative entite = entiteService.findByLibelle(valideEntite.getEntite().getLibelle());
				valideEntite.setEntite(entite);
				budgetEntiteDao.save(valideEntite);
			}
	       return 1;
		} else 
			return -2;
	}
	
	@Override
	@Transactional
	public int deleteByReference(String reference) {
		return budgetEntiteDao.deleteByReference(reference);
	}

	@Override
	@Transactional
	public int deleteByBudgetReference(String reference) {
		return budgetEntiteDao.deleteByBudgetReference(reference);
	}

	
	
}
