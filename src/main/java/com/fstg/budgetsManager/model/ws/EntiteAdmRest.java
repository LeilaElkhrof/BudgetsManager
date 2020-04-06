package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.EntiteAdministrative;
import com.fstg.budgetsManager.model.service.facade.EntiteAdmService;

@RestController
@RequestMapping("budget-api/entites")
@CrossOrigin(value = "http://localhost:4200",maxAge = 3600)
public class EntiteAdmRest {

	@Autowired
	EntiteAdmService entiteService;

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return entiteService.deleteByLibelle(libelle);
	}

	@GetMapping("/libelle/{libelle}")
	public EntiteAdministrative findByLibelle(@PathVariable String libelle) {
		return entiteService.findByLibelle(libelle);
	}

	@GetMapping("/")
	public List<EntiteAdministrative> findAll() {
		return entiteService.findAll();
	}
	
	@PostMapping("/")
	public int save(@RequestBody EntiteAdministrative entite) {
		return entiteService.save(entite);
	}
	
	
}
