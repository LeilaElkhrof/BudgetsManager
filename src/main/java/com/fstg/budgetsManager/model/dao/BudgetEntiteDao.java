package com.fstg.budgetsManager.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.BudgetEntite;

@Repository
public interface BudgetEntiteDao extends JpaRepository<BudgetEntite, Long> {

	public List<BudgetEntite> findByBudgetReference(String reference);
	public List<BudgetEntite> findByEntiteLibelle(String libelle);
	public BudgetEntite findByReference(String reference);
}
