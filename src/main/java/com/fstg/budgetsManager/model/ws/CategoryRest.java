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

import com.fstg.budgetsManager.bean.Category;
import com.fstg.budgetsManager.model.service.facade.CategoryService;



@RestController
@RequestMapping("categories/")
@CrossOrigin(value = "http://localhost:4200",maxAge = 3600)
public class CategoryRest {
	
	@Autowired
	private CategoryService cs;
	
	@PostMapping("")
	public int createCategory(@RequestBody Category cat) {
		return cs.createCategory(cat);
	}

	@GetMapping("{lib}")
	public Category findByLibelle(@PathVariable String lib) {
		return cs.findByLibelle(lib);
	}

	@GetMapping("")
	public List<Category> getAllCategories() {
		return cs.getAllCategories();
	}
	
	

	
	

}
