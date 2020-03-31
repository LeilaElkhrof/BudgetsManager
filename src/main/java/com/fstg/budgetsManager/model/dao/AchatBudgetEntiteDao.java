package com.fstg.budgetsManager.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.AchatBudgetEntite;



@Repository
public interface AchatBudgetEntiteDao extends JpaRepository<AchatBudgetEntite, Long>{
	public List<AchatBudgetEntite> findByBudgetEntiteReference(String reference);
	public List<AchatBudgetEntite> findByAchatCode(String code);
}
