package br.com.livraria.action;

import java.util.Set;

import br.com.livraria.helper.Carrinho;
import br.com.livraria.model.Livro;
import br.com.livraria.model.Usuario;
import br.com.livraria.service.PedidoService;

/**
 * Fecha um pedido
 */
public class FecharPedidoAction extends Action {

	@Override
	public void process() throws Exception {
		
		Carrinho carrinho = (Carrinho) getSession().getAttribute("carrinho");
		Usuario usuario = (Usuario) getSession().getAttribute("usuario");
		
		PedidoService pedidoService = serviceFactory.getService(PedidoService.class);
		Set<Livro> livros = carrinho.getLivros();
		
		pedidoService.fecharPedido(usuario, livros);
		
		getSession().setAttribute("carrinho", null);
		redirect("pedido_efetuado.jsp");
	}
}
