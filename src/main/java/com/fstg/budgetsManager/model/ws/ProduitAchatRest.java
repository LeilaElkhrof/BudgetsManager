package com.fstg.budgetsManager.model.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.ProduitAchat;
import com.fstg.budgetsManager.model.service.facade.ProduitAchatService;


@RestController
@RequestMapping("ProduitAchat")
public class ProduitAchatRest {
	@Autowired
	private ProduitAchatService produitAchatService;

	@GetMapping("/Achat/dateAchat/{dateAchat}")
	public List<ProduitAchat> findByAchatDateAchat(
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateAchat) {
		return produitAchatService.findByAchatDateAchat(dateAchat);
	}

	@GetMapping("/Produit/codeScanbar/{codeScanbar}")
	public List<ProduitAchat> findByProduitCodeScanbar(@PathVariable String codeScanbar) {
		return produitAchatService.findByProduitCodeScanbar(codeScanbar);
	}

	@PostMapping("/")
	public int save(@RequestBody Achat achat) {
		return produitAchatService.save(achat, achat.getProduitAchats());
	}

	@PostMapping("/quantite/{quantite}")
	public int updateAchat(@PathVariable double quantite, @RequestBody List<ProduitAchat> produitAchats) {
		return produitAchatService.updateAchat(quantite, produitAchats);
	}

}
