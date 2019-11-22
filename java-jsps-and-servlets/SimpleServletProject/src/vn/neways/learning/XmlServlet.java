package vn.neways.learning;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		
	}
	int count = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("XML Servlet Configuration");
		String user = request.getParameter("userName");
		response.getWriter().append("Hello: " + user);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("XML Servlet Configuration");
		String user = request.getParameter("userName");
		String userFull = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		String localtion = request.getParameter("localtion");
		HttpSession session = request.getSession();
		session.setAttribute("userNameSession", user + "Session");
		ServletContext context = request.getServletContext();
		context.setAttribute("count", count++);
		
		response.getWriter().append("Hello: " + "userName: " + user + 
				"</br> fullName: " + userFull +
				"</br> prof: " + prof +
				"</br> localtion: " + localtion +
				"</br> User session: " + session.getAttribute("userNameSession") + 
				"</br> Context: " + context.getAttribute("count") + 
				"</br> defaultUser: " + this.getServletConfig().getInitParameter("defaultUser")
				);
	}
}
