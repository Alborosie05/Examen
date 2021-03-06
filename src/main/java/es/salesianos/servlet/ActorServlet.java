package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.assembler.ActorAssembler;
import es.salesianos.service.ActorService;

public class ActorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ActorService serviceActor = new ActorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Actor actor = ActorAssembler.assembleActorFrom(req);
		serviceActor.insert(actor);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codActor = req.getParameter("cod");
		if (codActor != null) {
			serviceActor.delete(codActor);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String beginDateString = req.getParameter("beginDate");
		if (beginDateString != null) {
			int endDate = Integer.parseInt(req.getParameter("endDate"));
			int beginDate = Integer.parseInt(req.getParameter("beginDate"));
			List<Actor> listAllActors = serviceActor.filterAllActor(beginDate, endDate);
			req.setAttribute("listAllActores", listAllActors);
		}
		List<Actor> listAllActors = serviceActor.selectAllActor();
		req.setAttribute("listAllActors", listAllActors);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addActor.jsp");
		dispatcher.forward(req, resp);
	}
}
