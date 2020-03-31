package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.Responsabilite;
import com.fstg.budgetsManager.model.service.facade.ResponsabiliteService;

@RestController
@RequestMapping("/budget-api/Responsabilite")
public class ResponsabiliteRest {

	@Autowired
	private ResponsabiliteService responsabiliteService;

	@GetMapping("/")
	public List<Responsabilite> findAll() {
		return responsabiliteService.findAll();
	}
	
	@GetMapping("/libelle/{libelle}")
	public Responsabilite findByLibelle(@PathVariable String libelle) {
		return responsabiliteService.findByLibelle(libelle);
	}
	
	@PostMapping("/")
	public int save(@RequestBody Responsabilite responsabilite) {
		return responsabiliteService.save(responsabilite);
	}
}
