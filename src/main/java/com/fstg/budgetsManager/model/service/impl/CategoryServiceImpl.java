package com.fstg.budgetsManager.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.Category;
import com.fstg.budgetsManager.model.dao.CategoryDao;
import com.fstg.budgetsManager.model.service.facade.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao catDao;

	@Override
	public int createCategory(Category cat) {
		Category catDB = findByLibelle(cat.getLibelle());
		if (catDB != null) {
			return -1;
		} else {
			catDao.save(cat);
			return 1;
		}
	}

	@Override
	public Category findByLibelle(String lib) {
		return catDao.findByLibelle(lib);
	}

	@Override
	public List<Category> getAllCategories() {
		return catDao.findAll();
	}

}
