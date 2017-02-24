package br.com.livraria.action;

import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.Pedido;
import br.com.livraria.model.Usuario;
import br.com.livraria.service.PedidoService;
import br.com.livraria.view.PedidoView;

/**
 * Lista os pedidos feitos pelo usuário
 */
public class ListarPedidosAction extends Action {

	@Override
	public void process() throws Exception {
	
		getSession().setAttribute("menuAtivo", "pedidos");
		Usuario usuario = (Usuario) getSession().getAttribute("usuario");
		
		// Só obtém os pedidos se existir um usuário logado
		if (usuario != null) {
			PedidoService pedidoService = serviceFactory.getService(PedidoService.class);
			List<Pedido> pedidos = pedidoService.getPedidosByUsuario(usuario);
			
			List<PedidoView> pedidosView = new ArrayList<PedidoView>();
			for (Pedido pedido : pedidos) {
				PedidoView pedidoView = new PedidoView(pedido);
				pedidosView.add(pedidoView);
			}
			
			getRequest().setAttribute("pedidos", pedidosView);
		}
		
		forward("lista_pedidos.jsp");
	}
}
