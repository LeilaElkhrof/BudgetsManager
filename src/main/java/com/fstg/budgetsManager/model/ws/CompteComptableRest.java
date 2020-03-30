package com.fstg.budgetsManager.model.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.CompteComptable;
import com.fstg.budgetsManager.model.service.facade.CompteComptableService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("compteComptable")
public class CompteComptableRest {
	@Autowired
	private CompteComptableService compteComptableService;

	@GetMapping("/libelle/{libelle}")
	public CompteComptable findByLibelle(@PathVariable String libelle) {
		return compteComptableService.findByLibelle(libelle);
	}

	@PostMapping("/")
	public int save(@RequestBody CompteComptable compteComptable) {
		return compteComptableService.save(compteComptable);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return compteComptableService.deleteByLibelle(libelle);
	}

}
