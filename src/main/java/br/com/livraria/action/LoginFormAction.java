package br.com.livraria.action;

/**
 * Abre a tela de formulário de login
 */
public class LoginFormAction extends Action {

	@Override
	public void process() throws Exception {
		getSession().setAttribute("menuAtivo", "login");
		forward("login.jsp");
	}
}
