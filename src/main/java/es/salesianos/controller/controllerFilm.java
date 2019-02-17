package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Actor;
import es.salesianos.model.Film;
import es.salesianos.service.FilmService;

@Controller
public class controllerFilm {

	@Autowired
	FilmService service;
	//Accedemos aqui al clicar al enlace "Añadir Actor" desde el index
	
		@GetMapping(path="/film")
		public ModelAndView getAddFilmPage() {
			List<Film> listAllFilms = service.selectAllFilm();
			ModelAndView model = new ModelAndView("addFilm");
			model.addObject("film",new Film());
			model.addObject("listAllFilms", listAllFilms);
			return model;
		}
		
		@PostMapping(path="/addFilm")
		public ModelAndView saveFilm(Film film)  {
			service.insert(film);
			List<Film> listAllFilms = service.selectAllFilm();
			ModelAndView model = new ModelAndView("addFilm");
			model.addObject("actor",new Actor());
			model.addObject("listAllFilms", listAllFilms);
			return model;
		}
		
		@GetMapping(path="/deleteFilm")
		public ModelAndView saveActor(@RequestParam String cod)  {
			service.delete(cod);
			List<Film> listAllFilms = service.selectAllFilm();
			ModelAndView model = new ModelAndView("addFilm");
			model.addObject("film",new Film());
			model.addObject("listAllFilms", listAllFilms);
			return model;
		}
		
		@GetMapping(path = "/filmactor")
		public ModelAndView getfilmActor() {
			ModelAndView model = new ModelAndView("filmactors");
			model.addObject("listAllFilms", service.selectAllFilm());
			return model;
		}
}
