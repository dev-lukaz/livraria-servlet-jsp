package br.com.livraria.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.action.Action;

@WebServlet("*.action")
public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String path = request.getServletPath();
		path = path.substring(1, path.indexOf("."));
		
		String actionClass = ActionProperties.getActionClass(path);
		
		if(actionClass == null) {
			throw new ServletException("A action '" + path + "' não está mapeada");
		}
			
		try {
			Action action = (Action) Class.forName(actionClass).newInstance();
			action.setRequest(request);
			action.setResponse(response);
			action.runAction();
		
		} catch (Exception e) {
			request.setAttribute("exception", e);
			throw new ServletException(e);
		}
	}
}
