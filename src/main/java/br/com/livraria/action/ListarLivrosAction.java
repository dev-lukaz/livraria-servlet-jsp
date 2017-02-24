package br.com.livraria.action;

import java.util.List;

import br.com.livraria.model.Livro;
import br.com.livraria.service.LivroService;

/**
 * Lista os livros cadastrados
 */
public class ListarLivrosAction extends Action {

	@Override
	public void process() throws Exception {
		
		getSession().setAttribute("menuAtivo", "livros");
		
		LivroService livroService = serviceFactory.getService(LivroService.class);
		List<Livro> livros = livroService.getLivros();
		
		getRequest().setAttribute("livros", livros);
		
		forward("lista_livros.jsp");
	}
}
