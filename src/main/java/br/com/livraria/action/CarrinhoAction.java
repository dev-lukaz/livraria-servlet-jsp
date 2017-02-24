package br.com.livraria.action;

import br.com.livraria.helper.Carrinho;
import br.com.livraria.model.Livro;
import br.com.livraria.service.LivroService;

/**
 * Adiciona um livro no carrinho
 */
public class CarrinhoAction extends Action {

	@Override
	public void process() throws Exception {
		LivroService livroService = serviceFactory.getService(LivroService.class);
	
		Carrinho carrinho = (Carrinho) getSession().getAttribute("carrinho");
		if (carrinho == null) {
			// Se um carrinho ainda não existe, cria
			carrinho = new Carrinho();
			getSession().setAttribute("carrinho", carrinho);
		}
		
		String op = getRequest().getParameter("op");
		String livroId = getRequest().getParameter("id");
		
		// O parâmetro 'op' indica se é para inserir ou remover um item
		
		if (op != null && op.equals("inserir") && livroId != null) {
			Livro livro = livroService.getLivroById(Integer.parseInt(livroId));
			carrinho.adicionarItem(livro);
		
		} else if (op != null && op.equals("remover") && livroId != null) {
			carrinho.removerItem(Integer.parseInt(livroId));
		}
		
		getSession().setAttribute("menuAtivo", "carrinho");
		forward("carrinho.jsp");
	}
}
