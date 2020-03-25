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
	public List<Budget> findAll() {
		return budgetDao.findAll();
	}
	
public double[] CalculMontant(List<BudgetEntite> budgetEntites){
	double totalMontantInv = 0.0, totalMontantFonc = 0.0;
	
	  for(BudgetEntite budgetEntite : budgetEntites) {
		 totalMontantFonc += budgetEntite.getMontantFonct();
		 totalMontantInv += budgetEntite.getMontantInv();
	  }
	  
	  double[] montants = {totalMontantFonc, totalMontantInv};
	return montants;
}

	@Override
	public int save(Budget budget, List<BudgetEntite> budgetEntites) {
       Budget foundedBudget = findByReference(budget.getReference());
  
       double[] montants = CalculMontant(budgetEntites);
 		  
       if(foundedBudget != null)
    	   return -1;
       
       else if(budgetEntiteService.validateBudgetEntites(budgetEntites) == null) {
    	   return -2;
       }
       
       else if( montants[0] > budget.getMontantFonct() || montants[1] > budget.getMontantInv())
    	   return -3;
       
       else{    	   
		budget.setAnnee(DateUtil.year());
    	   budgetDao.save(budget);
    	   budgetEntiteService.save(budget, budgetEntites);
    	   return 1;
       }
		
	}

	@Override
	@Transactional
	public int deleteByReference(String reference) {
		int res1 = budgetEntiteService.deleteByBudgetReference(reference);
		int res2 = budgetDao.deleteByReference(reference);
		return res1 + res2;
	}

}
