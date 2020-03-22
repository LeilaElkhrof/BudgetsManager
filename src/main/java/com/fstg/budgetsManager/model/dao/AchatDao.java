package com.fstg.budgetsManager.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Achat;



@Repository
public interface AchatDao extends JpaRepository<Achat, Long>{
	public Achat findByCode(String code);
	public List<Achat> findByDateAchat(Date dateAchat);
	public int deleteByCode(String code);
}
