package br.com.livraria.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.livraria.model.Usuario;

public class UsuarioDAO extends DAO<Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	/**
	 * Verifica se um usuário existe, com base no seu e-mail
	 * @param email
	 * @return
	 * @throws DAOException
	 */
	public boolean existeUsuario(String email) throws DAOException {
		Query q = createQuery("SELECT COUNT(u) FROM Usuario u WHERE UPPER(u.email) = :email");
		q.setParameter("email", email.toUpperCase());
		long count = (Long) q.getResultList().get(0);
		return count > 0;
	}
	
	/**
	 * Obtém um usuário com base no e-mail
	 * @param email
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Usuario getUsuarioByEmail(String email) throws DAOException {
		Query q = createQuery("SELECT u FROM Usuario u WHERE UPPER(u.email) = :email");
		q.setParameter("email", email.toUpperCase());
		
		List<Usuario> result = q.getResultList();
		
		if (result.size() == 0) {
			return null;
		} else {
			return result.get(0);
		}
	}
}
