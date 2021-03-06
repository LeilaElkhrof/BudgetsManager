package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.Budget;
import com.fstg.budgetsManager.model.service.facade.BudgetService;

@RestController
@RequestMapping("budget-api/budgets")
public class BudgetRest {

	 @Autowired
     BudgetService budgetService;

     @DeleteMapping("/reference/{reference}")
     public int deleteByReference(@PathVariable String reference) {
		return budgetService.deleteByReference(reference);
	}

	@GetMapping("/reference/{reference}")
     public Budget findByReference(@PathVariable String reference) {
   	 return budgetService.findByReference(reference);
     }

     @GetMapping("/")
     public List<Budget> findAll() {
	 return budgetService.findAll();
     }

     @PostMapping("/")
     public int save(@RequestBody Budget budget) {
	 return budgetService.save(budget, budget.getBudgetEntites());
     }
 
 
}
