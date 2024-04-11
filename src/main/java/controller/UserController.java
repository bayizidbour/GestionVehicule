package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestionParc.model.User;
import com.gestionParc.services.AgenceService;
import com.gestionParc.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	AgenceService agenceService;
	
	@GetMapping
	public String index (Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "user/index";
	}
	
	
	@GetMapping("/new")
	public String newUser (Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("agences", agenceService.getAllAg());
		return "user/new";
	}
	

	@PostMapping
	public String insertUser (Model model, BindingResult result, @Valid User user, RedirectAttributes ra) {
		
		if (result.hasErrors()) {
			model.addAttribute("agences", agenceService.getAllAg());
			return "user/index";
		}
		
		if(user.getIdUser() != null) {
			userService.updateUser(user.getIdUser(), user);
			ra.addFlashAttribute("success", "User modifié avec succès ! ");	
		}else {
			userService.addUser(user);
			ra.addFlashAttribute("success", "User créé avec succès ! ");
		}
		return "redirect:/user";
	}
	
	
}
