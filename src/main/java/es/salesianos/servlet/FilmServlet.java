package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Film;
import es.salesianos.model.assembler.FilmAssembler;
import es.salesianos.service.FilmService;

public class FilmServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private FilmService serviceFilm = new FilmService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Film film = FilmAssembler.assembleFilmFrom(req);
		serviceFilm.insert(film);
		doAction(req, resp);
	}
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codFilm = req.getParameter("cod");
		if(null != codFilm) {
			serviceFilm.delete(codFilm);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Film> selectAllFilms = serviceFilm.selectAllFilm();
		req.setAttribute("listAllFilms", selectAllFilms);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addFilm.jsp");
		dispatcher.forward(req, resp);
	}
}
