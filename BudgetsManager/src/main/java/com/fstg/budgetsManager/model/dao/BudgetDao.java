package com.fstg.budgetsManager.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Budget;

@Repository
public interface BudgetDao extends JpaRepository<Budget, Long>{

	public Budget findByReference(String reference);
	
	@Query("SELECT b FROM Budget b WHERE b.creditOuvert > :valeur")
	public List<Budget> findHigh(@Param(value = "valeur") double valeur) ;
	
	@Query("SELECT b FROM Budget b WHERE b.creditOuvert < :valeur")
	public List<Budget> findLow(@Param(value = "valeur") double valeur) ;
}
