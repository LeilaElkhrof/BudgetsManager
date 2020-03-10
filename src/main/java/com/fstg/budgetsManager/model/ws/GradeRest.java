package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.Grade;
import com.fstg.budgetsManager.model.service.facade.GradeService;



@RestController
@RequestMapping("projet-api/grade")
public class GradeRest{

	@Autowired
	GradeService gradeService;

	@GetMapping("libelle/{libelle}")
	public Grade findByLibelle(@PathVariable String libelle) {
		return gradeService.findByLibelle(libelle);
	}

	@PostMapping("/")
	public int save(@RequestBody Grade grade) {
		return gradeService.save(grade);
	}

	@GetMapping("/")
	public List<Grade> findAll() {
		return gradeService.findAll();
	}

}