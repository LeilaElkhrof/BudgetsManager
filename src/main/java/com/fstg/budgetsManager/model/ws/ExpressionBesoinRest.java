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

import com.fstg.budgetsManager.bean.ExpressionBesoin;
import com.fstg.budgetsManager.model.service.facade.ExpressionBesoinService;


@RestController
@RequestMapping("ebs")
@CrossOrigin(value = "http://localhost:4200",maxAge = 3600)
public class ExpressionBesoinRest {
	
	@Autowired
	private ExpressionBesoinService ebs;

    @PostMapping("/")
	public int createExpB(@RequestBody ExpressionBesoin expb) {
		return ebs.createExpB(expb);
	}

    @GetMapping("/")
	public List<ExpressionBesoin> getAllExpB() {
		return ebs.getAllExpB();
	}

    @GetMapping("/eb/{libelle}")
	public List<ExpressionBesoin> getByEntiteAdministrativeLibelle(@PathVariable String libelle) {
		return ebs.getByEntiteAdministrativeLibelle(libelle);
	}

    @DeleteMapping("/eb/{id}")
	public int deleteById(@PathVariable Long id) {
		return ebs.deleteById(id);
	}
	
	
    
	

}
