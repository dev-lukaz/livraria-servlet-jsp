package br.com.livraria.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.livraria.model.Pedido;
import br.com.livraria.model.Usuario;

public class PedidoDAO extends DAO<Pedido> {

	public PedidoDAO() {
		super(Pedido.class);
	}

	/**
	 * Obtém o maior sequencial de número de pedido
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public int getMaxNumPedido() throws DAOException {
		Query q = createQuery("SELECT MAX(p.id) FROM Pedido p");

		List<String> result = q.getResultList();
		
		String max = result.get(0);
		
		if (max == null) {
			return 0;
		} else {
			return Integer.parseInt(result.get(0));
		}
	}
	
	/**
	 * Obtém os pedidos atrelados a um usuário
	 * @param usuario
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidosByUsuario(Usuario usuario) throws DAOException {
		Query q = createQuery("SELECT p FROM Pedido p WHERE p.usuario.id = :usuarioId ORDER BY p.data DESC");
		q.setParameter("usuarioId", usuario.getId());
		return q.getResultList();
	}
	
	/**
	 * Obtém os pedidos que estão com determinado status
	 * @param status
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidosByStatus(int status) throws DAOException {
		Query q = createQuery("SELECT p FROM Pedido p WHERE p.status = :status ORDER BY p.data");
		q.setParameter("status", status);
		return q.getResultList();
	}
}
