package com.fstg.budgetsManager.model.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.model.service.facade.AchatService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("achat")
public class AchatRest {
	@Autowired
	private AchatService achatService;

	@GetMapping("/code/{code}")
	public Achat findByCode(@PathVariable String code) {
		return achatService.findByCode(code);
	}

	@GetMapping("/dateAchat/{dateAchat}")
	public List<Achat> findByDateAchat(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateAchat) {
		return achatService.findByDateAchat(dateAchat);
	}

	@GetMapping("/")
	public List<Achat> findAll() {
		return achatService.findAll();
	}

	@DeleteMapping("/code/{code}")
	public int deleteByCode(@PathVariable String code) {
		return achatService.deleteByCode(code);
	}

	@PostMapping("/")
	public int save(@RequestBody Achat achat) {
		return achatService.save(achat, achat.getProduitAchats());
	}

}
