package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActorController {
    
    private final ActorRepository actorRepository;
    
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    
    @GetMapping("/actors")
    public String listActors(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 10;
        Page<Actor> actorPage = actorRepository.findAll(PageRequest.of(page, pageSize));
        
        model.addAttribute("actors", actorPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", actorPage.getTotalPages());
        
        // Calculate pagination range
        int endPage = Math.min(page + 3, actorPage.getTotalPages() - 1);
        model.addAttribute("endPage", endPage);
        
        return "actors";
    }
} 