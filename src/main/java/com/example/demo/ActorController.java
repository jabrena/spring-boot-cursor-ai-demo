package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.PageRequest;

@Controller
public class ActorController {
    
    private final ActorRepository actorRepository;
    
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    
    @GetMapping("/actors")
    public String listActors(Model model) {
        model.addAttribute("actors", actorRepository.findAllBy(PageRequest.of(0, 10)));
        return "actors";
    }
} 