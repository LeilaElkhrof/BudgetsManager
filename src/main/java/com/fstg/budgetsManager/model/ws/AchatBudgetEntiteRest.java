package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.AchatBudgetEntite;
import com.fstg.budgetsManager.model.service.facade.AchatBudgetEntiteService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("achatBudgetEntite")
public class AchatBudgetEntiteRest {
	@Autowired
	private AchatBudgetEntiteService achatBudgetEntiteService;

	@GetMapping("/budgetEntite/reference/{reference}")
	public List<AchatBudgetEntite> findByBudgetEntiteReference(@PathVariable String reference) {
		return achatBudgetEntiteService.findByBudgetEntiteReference(reference);
	}

	@PostMapping("/")
	public int save(@RequestBody Achat achat) {
		return achatBudgetEntiteService.save(achat, achat.getAchatBudgetEntites());
	}

	@GetMapping("/achat/code/{code}")
	public List<AchatBudgetEntite> findByAchatCode(@PathVariable String code) {
		return achatBudgetEntiteService.findByAchatCode(code);
	}

}
