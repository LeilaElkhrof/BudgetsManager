package com.fstg.budgetsManager.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Category;


@Repository
public interface CategoryDao extends JpaRepository<Category, Long>{
	Category findByLibelle(String lib);
}
