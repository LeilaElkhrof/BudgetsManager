package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.Budget;
import com.fstg.budgetsManager.bean.BudgetEntite;


public interface BudgetService {
	
	  public Budget findByReference(String reference);
		public List<Budget> findHigh( double valeur) ;
		public List<Budget> findLow(double valeur) ;
		public List<Budget> findAll();
		public int save(Budget budget, List<BudgetEntite> budgetEntites);
		
	}
