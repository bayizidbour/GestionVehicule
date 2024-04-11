package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestionParc.model.Agence;
import com.gestionParc.services.AgenceService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/agence")
public class AgenceController {

	@Autowired
	AgenceService agenceService;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("agences", agenceService.getAllAg());
		return "agence/index";
	}
	
	@GetMapping("/new")
	public String newAgence (Model model) {
		model.addAttribute("agence", new Agence());
		return "agence/new";
	}
	
	@PostMapping
	public String addAgence (@Valid Agence agence, BindingResult result, RedirectAttributes ra) {
		
		if(result.hasErrors()) {
			return"agence/new";
		}
		
		if(agence.getIdAgence() != null ) {
			agenceService.updateAgence(agence.getIdAgence(), agence);
			ra.addFlashAttribute("success", "Agence modifié avec succès ! ");
		}else {
			agenceService.addAgence(agence);
			ra.addFlashAttribute("success", "Agence ajouté avec succès ! ");
		}
		return "redirect:/agence";
	}
}
