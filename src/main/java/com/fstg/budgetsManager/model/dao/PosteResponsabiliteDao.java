package com.fstg.budgetsManager.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Echelon;
import com.fstg.budgetsManager.bean.Personnel;
import com.fstg.budgetsManager.bean.PosteResponsabilite;

@Repository
public interface PosteResponsabiliteDao extends JpaRepository<PosteResponsabilite, Long> {
	
	public PosteResponsabilite findByEchelon(Echelon echelon);

	public PosteResponsabilite findByPersonnel(Personnel personnel);

}
