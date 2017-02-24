package br.com.livraria.action;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.livraria.service.ServiceFactory;
import br.com.livraria.util.JPAUtil;

public abstract class Action {

	private HttpServletRequest request;
	private HttpServletResponse response;
	protected ServiceFactory serviceFactory;

	protected Action() {
		this.serviceFactory = ServiceFactory.getInstance();
	}

	public void runAction() throws Exception {
		EntityManager em = JPAUtil.getInstance().createEntityManager();

		try {
			em.getTransaction().begin();
			process();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw e;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	public abstract void process() throws Exception;

	protected void forward(String path) throws Exception {
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void redirect(String path) throws Exception {
		String contextRoot = request.getContextPath();
		response.sendRedirect(contextRoot + "/" + path);
	}

	protected HttpSession getSession() {
		return request.getSession();
	}

	protected HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	protected HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
