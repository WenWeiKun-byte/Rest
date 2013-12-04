package com.cookbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cookbook.ejb.SphereBean;

/**
 * Servlet implementation class SphereServlet
 */
public class SphereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// @EJB
	SphereBean sphere;

	public SphereServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Context context = null;
		try {
			context = new InitialContext();
			sphere = (SphereBean) context.lookup("java:module/SphereBean");
			System.out.print(sphere.hashCode()+"~~~~~~~~~~~~~~~~~~~~~");
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet VolumeServlet</title>");
			out.println("</head>");
			out.println("<body>");
			sphere.setUnit("kilometers");
			out.printf("<h3>Volume: %6.2f %s</h3>", sphere.computeVolume(3.0),
					sphere.getUnit());
			out.printf("<h3>Instance:  %s</h3>", sphere.hashCode());
			out.println("</body>");
			out.println("</html>");
			out.flush();
		} finally {
			out.close();
		}
	}
}
