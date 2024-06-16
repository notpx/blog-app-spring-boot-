package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthContr {
	
	@Autowired
	AuthRepo authrepo;
	
	public AuthContr(AuthRepo authrepo) {
		this.authrepo = authrepo;
	}
	
	@Autowired
	PostRepo postrepo;
	
	@GetMapping("/newauthor")
	public String addNewAuthor(Model model) {
		Author author = new Author();
		model.addAttribute("author", author);
		return "registerauthpage";
	}
	
	@PostMapping("/newauthor")
	public String addSaveNewAuthor(@ModelAttribute Author author) {
		authrepo.save(author);
		return "redirect:/addnewpost";
	}

}
