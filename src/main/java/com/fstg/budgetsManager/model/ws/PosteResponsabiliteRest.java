package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.PosteResponsabilite;
import com.fstg.budgetsManager.model.service.facade.PosteResponsabiliteService;

@RestController
@RequestMapping("/budget-api/PosteResponsabilite")
public class PosteResponsabiliteRest {
	@Autowired
	private PosteResponsabiliteService PosteResponsabiliteService;
	
	@GetMapping("/")
	public List<PosteResponsabilite> findAll() {
		return PosteResponsabiliteService.findAll();
	}
	
	@PostMapping("/")
	public int save(PosteResponsabilite posteResponsabilite) {
		return PosteResponsabiliteService.save(posteResponsabilite);
	}

}
