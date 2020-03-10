package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.Personnel;
import com.fstg.budgetsManager.model.service.facade.PersonnelService;





@RestController
@RequestMapping("projet-api/personnel")
public class PersonnelRest {

	@Autowired
	PersonnelService personnelService;

	@GetMapping("/cin/{cin}")
	public Personnel findByCin(@PathVariable String cin) {
		return personnelService.findByCin(cin);
	}
	
	@GetMapping("/echelon/libelle/{libelle}")
	public List<Personnel> findByEchelonLibelle(@PathVariable String libelle) {
		return personnelService.findByEchelonLibelle(libelle);
	}

	@GetMapping("/")
	public List<Personnel> findAll() {
		return personnelService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Personnel personnel) {
		return personnelService.save(personnel);
	}

	@GetMapping("/salaire/{²valeur}")
	public List<Personnel> findGrandSalaire(@PathVariable Double valeur) {
		return personnelService.findGrandSalaire(valeur);
	}

	@GetMapping("/salary/{valeur}")//attention ici on doit changer le contenu de getmapping
	public List<Personnel> findPetitSalaire(@PathVariable Double valeur) {
		return personnelService.findPetitSalaire(valeur);
	}
	@GetMapping("/entite/libelle/{libelle}")
	public List<Personnel> findByEntiteAdmLibelle(@PathVariable String libelle) {
		return personnelService.findByEntiteAdmLibelle(libelle);
	}
	@PutMapping("/cin/{cin}")
	public int transfert(@PathVariable String cin) {
		return personnelService.transfert(cin);
	}

	
}


