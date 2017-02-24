package br.com.livraria.action;

import br.com.livraria.service.LivroService;

/**
 * Exclui um livro
 */
public class ExcluirLivroAction extends Action {

	@Override
	public void process() throws Exception {

		String livroId = getRequest().getParameter("id");
		
		LivroService livroService = serviceFactory.getService(LivroService.class);
		livroService.excluir(Integer.parseInt(livroId));

		redirect("admin/ListarLivros.action");
	}
}
