package br.com.livraria.servlet;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Esta classe mapeia URIs para classes de action
 */
public abstract class ActionProperties {

	private static final Map<String, String> actions;

	static {
		actions = new LinkedHashMap<>();
		actions.put("PesquisarLivros", "br.com.livraria.action.PesquisarLivrosAction");
		actions.put("LoginForm", "br.com.livraria.action.LoginFormAction");
		actions.put("Login", "br.com.livraria.action.LoginAction");
		actions.put("Logout", "br.com.livraria.action.LogoutAction");
		actions.put("CadastrarUsuario", "br.com.livraria.action.CadastrarUsuarioAction");
		actions.put("Carrinho", "br.com.livraria.action.CarrinhoAction");
		actions.put("FecharPedido", "br.com.livraria.action.FecharPedidoAction");
		actions.put("ListarPedidos", "br.com.livraria.action.ListarPedidosAction");
		actions.put("admin/ListarLivros", "br.com.livraria.action.ListarLivrosAction");
		actions.put("admin/LivroForm", "br.com.livraria.action.LivroFormAction");
		actions.put("admin/ExcluirLivro", "br.com.livraria.action.ExcluirLivroAction");
		actions.put("admin/SalvarLivro", "br.com.livraria.action.SalvarLivroAction");
		actions.put("admin/GerenciarPedidos", "br.com.livraria.action.GerenciarPedidosAction");
		actions.put("admin/ProcessarPedidos", "br.com.livraria.action.ProcessarPedidosAction");
	}

	public static String getActionClass(String key) {
		return actions.get(key);
	}
}
