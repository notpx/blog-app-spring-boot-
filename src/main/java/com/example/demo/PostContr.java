package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PostContr {

	
	
	
	@Autowired
	PostRepo postrepo;
	
	public PostContr(PostRepo postrepo) {
		this.postrepo = postrepo;
	}
	
	@GetMapping("/allposts")
	public String seeAllPosts( Model model) {
		List<Post> post = postrepo.findAll();
		model.addAttribute("post", post);
		
		return "allposts";
		
		
	}

	
	@GetMapping("/newpost")
	public String addNewAuthor(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "addnewpost";
	}
	
	@PostMapping("/newpost")
	public String addSaveNewAuthor(@ModelAttribute Post post) {
		postrepo.save(post);
		return "allposts";
	}
}
