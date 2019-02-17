package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Film;
import es.salesianos.service.DirectorService;

@Controller
public class controllerDirector {
	
	@Autowired
	DirectorService service;
	
	
	@GetMapping(path="/addDirectorPage")
	public ModelAndView getAddDirectorPage() {
		List<Director> listAllDirectors = service.selectAllDirector();
		ModelAndView model = new ModelAndView("addDirector");
		model.addObject("director",new Director());
		model.addObject("listAllDirectors", listAllDirectors);
		return model;
	}
	
	@PostMapping(path="/director")
	public ModelAndView saveFilm(Director director)  {
		service.insert(director);
		List<Director> listAllDirectors = service.selectAllDirector();
		ModelAndView model = new ModelAndView("addDirector");
		model.addObject("director",new Director());
		model.addObject("listAllDirectors", listAllDirectors);
		return model;
	}
	
	@GetMapping(path="/deleteDirector")
	public ModelAndView saveActor(@RequestParam String cod)  {
		service.delete(cod);
		List<Director> listAllDirectors = service.selectAllDirector();
		ModelAndView model = new ModelAndView("addDirector");
		model.addObject("director",new Director());
		model.addObject("listAllDirectors", listAllDirectors);
		return model;
	}
	
	@PostMapping(path = "/searchActor")
	public ModelAndView searchActor(@RequestParam String name) {
		ModelAndView model = new ModelAndView("searchActor");
		model.addObject("listFilterDirector", service.filterAllDirector(name));
		return model;
	}

	@GetMapping(path = "/searchActor")
	public String getsearchActor() {
		return "searchActor";
	}
	
}
