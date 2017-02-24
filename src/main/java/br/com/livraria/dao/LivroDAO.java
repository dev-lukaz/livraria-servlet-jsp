package br.com.livraria.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.livraria.model.Livro;

public class LivroDAO extends DAO<Livro> {

	public LivroDAO() {
		super(Livro.class);
	}

	/**
	 * Obtém os livros com determinado título (parte dele)
	 * @param titulo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Livro> getLivrosByTitulo(String titulo) throws DAOException {
		Query q = createQuery("SELECT l FROM Livro l WHERE UPPER(l.titulo) LIKE :titulo ORDER BY l.titulo");
		q.setParameter("titulo", "%" + titulo.toUpperCase() + "%");
		return q.getResultList();
	}
	
	/**
	 * Obtém os livros com determinado autor (parte dele)
	 * @param autor
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Livro> getLivrosByAutor(String autor) throws DAOException {
		Query q = createQuery("SELECT l FROM Livro l WHERE UPPER(l.autor) LIKE :autor ORDER BY l.autor");
		q.setParameter("autor", "%" + autor.toUpperCase() + "%");
		return q.getResultList();
	}
	
	/**
	 * Obtém o livro com determinado ID
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Livro getLivroById(Integer id) throws DAOException {
		Query q = createQuery("SELECT l FROM Livro l WHERE l.id = :id");
		q.setParameter("id", id);

		List<Livro> result = q.getResultList();

		if (result.size() == 0) {
			return null;
		} else {
			return result.get(0);
		}
	}
	
	/**
	 * Obtém todos os livros cadastrados, ordenados por título
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Livro> getLivros() throws DAOException {
		Query q = createQuery("SELECT l FROM Livro l ORDER BY l.titulo");
		return q.getResultList();
	}

	/**
	 * Verifica se determinado livro faz parte de algum pedido
	 * @param livroId
	 * @return
	 * @throws DAOException
	 */
	public boolean isLivroEmPedido(Integer livroId) throws DAOException {
		Query q = createQuery("SELECT COUNT(*) FROM Pedido p INNER JOIN p.livros l WHERE l.id = :livroId");
		q.setParameter("livroId", livroId);
		Long count = (Long) q.getSingleResult();
		return count > 0;
	}
}
