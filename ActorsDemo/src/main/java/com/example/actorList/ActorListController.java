package com.example.actorList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")  // all the request like http://localhost:8080/
public class ActorListController {
	
	private ActorListRepository actorListRepository;
	
	@Autowired
	public ActorListController(ActorListRepository actorListRepository) 
	{
		this.actorListRepository = actorListRepository; 
	}
	
	// GET request like http://localhost:8080/watcherString
	// @PathVariable takes the value for the string <watcher> from the URL 
	// Model is a "variable" managed by Spring Boot
	@RequestMapping(value="/{watcher}", method=RequestMethod.GET)
	public String watcherActors( @PathVariable("watcher") String watcher, Model model)
	{
		List<Actor> actorsList = actorListRepository.findActorsByWatcher(watcher); 
		
		if (actorsList != null) 
		{ 
			// model contains couples <key, value>, in this case key = "actors"
			model.addAttribute("actors", actorsList); 
		} 
		
		// "actorsList" is a VIEW, saved as a resource
		return "actorsList";
	}
	
	@RequestMapping(value="/{watcher}", method=RequestMethod.POST) 
	public String addToActorList( @PathVariable("watcher") String watcher, Actor actor)
	{ 
		System.out.println("// **************");
		System.out.println("Received: " + actor.getCompleteName() + " - " + actor.getDetail() + " - " + actor.getWatcher());
		System.out.println("// **************");
		
		actor.setWatcher(watcher); 
		actorListRepository.save(actor); 
		
		// as in the previous methods we return a view passing a parameter
		// for this task we need a further controller
		return "redirect:/{watcher}"; 
	}

	
}
