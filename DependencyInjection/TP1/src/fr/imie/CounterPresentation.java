package fr.imie;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CounterPresentation
 */
@WebServlet("/CounterPresentation")
public class CounterPresentation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private @Inject CounterBeanInterface counterBean;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterPresentation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("counterValue", counterBean.getCount());
		request.getRequestDispatcher("./WEB-INF/counter.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		counterBean.increment();
		doGet(request, response);
	}

}
