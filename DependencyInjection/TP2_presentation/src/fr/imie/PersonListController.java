package fr.imie;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.DTO.PersonneDTO;

/**
 * Servlet implementation class PesronListController
 */
@WebServlet("/PersonListController")
public class PersonListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private @Inject @Named("PersonServiceSession") PersonServiceInterface personService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("persons", personService.getPersons() );
		request.getRequestDispatcher("/WEB-INF/PersonList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonneDTO newPerson = new PersonneDTO();
		newPerson.setNom(request.getParameter("lastName"));
		newPerson.setPrenom(request.getParameter("firstName"));
		try {
			personService.addPersons(newPerson);
		} catch (ImieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
