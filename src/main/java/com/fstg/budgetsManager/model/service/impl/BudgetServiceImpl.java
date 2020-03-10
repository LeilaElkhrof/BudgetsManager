package com.fstg.budgetsManager.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fstg.budgetsManager.bean.Budget;
import com.fstg.budgetsManager.bean.BudgetEntite;
import com.fstg.budgetsManager.model.dao.BudgetDao;
import com.fstg.budgetsManager.model.service.facade.BudgetEntiteService;
import com.fstg.budgetsManager.model.service.facade.BudgetService;
import com.fstg.budgetsManager.model.service.facade.EntiteAdmService;
import com.fstg.budgetsManager.model.util.DateUtil;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	BudgetDao budgetDao;
	
	@Autowired
	EntiteAdmService entiteAdmService;
	
	@Autowired
	BudgetEntiteService budgetEntiteService;
	
	@Override
	public Budget findByReference(String reference) {
		return budgetDao.findByReference(reference);
	}

	@Override
	public List<Budget> findHigh(double valeur) {
		return budgetDao.findHigh(valeur);
	}

	@Override
	public List<Budget> findLow(double valeur) {
		return budgetDao.findLow(valeur);
	}

	@Override
	public List<Budget> findAll() {
		return budgetDao.findAll();
	}

	@Override
	public int save(Budget budget, List<BudgetEntite> budgetEntites) {
       Budget foundedBudget = findByReference(budget.getReference());
       
       double totalMontantInv = 0.0, totalMontantFonc = 0.0;
		
		  for(BudgetEntite budgetEntite : budgetEntites) {
			 totalMontantFonc += budgetEntite.getMontantFonct();
			 totalMontantInv += budgetEntite.getMontantInv();
		  }
		  
       if(foundedBudget != null)
    	   return -1;
       
       else if(!budgetEntiteService.validateBudgetEntites(budget, budgetEntites)) {
    	   return -2;
       }
       
       else if( totalMontantFonc > budget.getMontantFonct() || totalMontantInv > budget.getMontantInv())
    	   return -3;
       
       else{
		budget.setAnnee(DateUtil.year());
    	   budgetDao.save(budget);
    	   budgetEntiteService.save(budget, budgetEntites);
    	   return 1;
       }
		
	}

}
