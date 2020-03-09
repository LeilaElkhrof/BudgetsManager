package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.Budget;
import com.fstg.budgetsManager.bean.BudgetEntite;


public interface BudgetEntiteService {

	public int save(Budget budget, List<BudgetEntite> budgetEntites);
	public boolean validateBudgetEntites(Budget budget, List<BudgetEntite> budgetEntites);
	public List<BudgetEntite> findByBudgetReference(String reference);
	public List<BudgetEntite> findByEntiteLibelle(String libelle);
	public BudgetEntite findByReference(String reference);
	public List<BudgetEntite> findAll();
	
}
