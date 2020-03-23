package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.BudgetEntite;
import com.fstg.budgetsManager.model.service.facade.BudgetEntiteService;

@RestController
@RequestMapping("budget-api/budgetEntites")
public class BudgetEntiteRest {

	@Autowired
	BudgetEntiteService budgetEntiteService;

	@DeleteMapping("/budget/reference/{reference}")
	public int deleteByBudgetReference(@PathVariable String reference) {
		return budgetEntiteService.deleteByBudgetReference(reference);
	}

	@GetMapping("/budget/reference/{reference}")
	public List<BudgetEntite> findByBudgetReference(@PathVariable String reference) {
		return budgetEntiteService.findByBudgetReference(reference);
	}

	@GetMapping("/entite/libelle/{libelle}")
	public List<BudgetEntite> findByEntiteLibelle(@PathVariable String libelle) {
		return budgetEntiteService.findByEntiteLibelle(libelle);
	}

	@GetMapping("/reference/{reference}")
	public BudgetEntite findByReference(@PathVariable String reference) {
		return budgetEntiteService.findByReference(reference);
	}
 
	@GetMapping("/")
	public List<BudgetEntite> findAll() {
		return budgetEntiteService.findAll();
	}
    /*
	@PostMapping("/")
	public int saveBudgetEntity(@RequestBody BudgetEntite budgetEntite) {
		return budgetEntiteService.saveBudgetEntity(budgetEntite);
	}*/

	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return budgetEntiteService.deleteByReference(reference);
	}

	
	
	
	
	
}
