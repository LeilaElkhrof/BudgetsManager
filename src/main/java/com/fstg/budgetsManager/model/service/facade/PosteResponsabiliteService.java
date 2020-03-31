package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.PosteResponsabilite;

public interface PosteResponsabiliteService {

	public List<PosteResponsabilite> findAll();

	public int save(PosteResponsabilite posteResponsabilite);

	//public List<PosteResponsabilite> findByEntiteAdmLibelle(String libelle);

}
