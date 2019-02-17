package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Actor;
import es.salesianos.service.ActorService;


@Controller
public class controllerActor {

	//Accedemos aqui al trabajar con Actor/Actores
	
	@Autowired
	ActorService service;
	
	//Accedemos aqui al clicar al enlace "Añadir Actor" desde el index
	
	@GetMapping(path="/addActorPage")
	public ModelAndView getAddActorPage() {
		List<Actor> listAllActors = service.selectAllActor();
		ModelAndView model = new ModelAndView("addActor");
		model.addObject("actor",new Actor());
		model.addObject("listAllActors", listAllActors);
		return model;
	}
	
	//Accedemos aqui al darle al submit del formulario para añadir Actor
	
	@PostMapping(path="/addActor")
	public ModelAndView saveActor(Actor actor)  {
		service.insert(actor);
		List<Actor> listAllActors = service.selectAllActor();
		ModelAndView model = new ModelAndView("addActor");
		model.addObject("actor",new Actor());
		model.addObject("listAllActors", listAllActors);
		return model;
	}
	
	
	//Accedemos aqui al darle al boton submit para buscar Actores entre dos fechas
	
	@PostMapping(path="/actorAges")
	public ModelAndView getBetweenAges(@RequestParam String beginDate, @RequestParam String endDate)  {
		Integer beginDate1=Integer.parseInt(beginDate);
		Integer endDate1=Integer.parseInt(endDate);
		List<Actor> listAllActors = service.filterAllActor(beginDate1, endDate1);
		ModelAndView model = new ModelAndView("addActor");
		model.addObject("actor",new Actor());
		model.addObject("listAllActors", listAllActors);
		return model;
	}
	
	//accedemos al darle al enlace de delete para eliminar un Actor
	
	@GetMapping(path="actorDelete")
	public ModelAndView getDeleteActorPage(@RequestParam String cod) {
		service.delete(cod);
		List<Actor> listAllActors = service.selectAllActor();
		ModelAndView model = new ModelAndView("addActor");
		model.addObject("actor",new Actor());
		model.addObject("listAllActors", listAllActors);
		return model;
	}
	@GetMapping(path = "/recoveryFilm")
	public ModelAndView recoveryFilm(@RequestParam Integer cod) {
		ModelAndView model = new ModelAndView("selectActor");
		model.addObject("codFilm", cod);
		model.addObject("listAllActors", service.selectAllActor());
		return model;
	}
	
}
