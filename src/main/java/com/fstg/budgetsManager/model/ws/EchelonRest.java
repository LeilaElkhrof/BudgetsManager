package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.Echelon;
import com.fstg.budgetsManager.model.service.facade.EchelonService;



@RestController
@RequestMapping("projet-api/echelon")
public class EchelonRest {

	@Autowired
	EchelonService echelonService;

	@GetMapping("libelle/{libelle}")
	public Echelon findByLibelle(@PathVariable String libelle) {
		return echelonService.findByLibelle(libelle);
	}


	
	@GetMapping("/grade/libelle/{libelle}")
	public List<Echelon> findByGradeLibelle(@PathVariable String libelle) {
		return echelonService.findByGradeLibelle(libelle);
	}
	
	@PostMapping("/")
	public int save(@RequestBody Echelon echelon) {
		return echelonService.save(echelon);
	}

	
	@GetMapping("/")
	public List<Echelon> findAll() {
		return echelonService.findAll();
	}

}
