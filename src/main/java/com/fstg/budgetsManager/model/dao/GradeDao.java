package com.fstg.budgetsManager.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Grade;



@Repository
public interface GradeDao extends JpaRepository<Grade, Long> {

	Grade findByLibelle(String libelle);

}


