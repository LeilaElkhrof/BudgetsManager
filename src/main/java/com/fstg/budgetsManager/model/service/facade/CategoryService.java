package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.Category;


public interface CategoryService {
	Category findByLibelle(String lib);
	int createCategory(Category cat);
	List<Category> getAllCategories();
}
