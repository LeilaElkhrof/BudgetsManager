package com.fstg.budgetsManager.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Budget;

@Repository
public interface BudgetDao extends JpaRepository<Budget, Long>{

	public Budget findByReference(String reference);
	public int deleteByReference(String reference);
}
