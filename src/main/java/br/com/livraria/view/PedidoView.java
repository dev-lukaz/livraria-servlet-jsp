package br.com.livraria.view;

import java.util.Date;
import java.util.Set;

import br.com.livraria.model.Livro;
import br.com.livraria.model.Pedido;
import br.com.livraria.model.Usuario;
import br.com.livraria.service.PedidoService;

public class PedidoView {

	private Pedido pedido;

	public PedidoView(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getId() {
		return pedido.getId();
	}

	public Date getData() {
		return pedido.getData();
	}

	public Double getValor() {
		return pedido.getValor();
	}

	public String getStatus() {
		// Formata o status do pedido
		switch (pedido.getStatus()) {
		case PedidoService.STATUS_ANALISE:
			return PedidoService.STATUS_DESC_ANALISE;
		case PedidoService.STATUS_APROVADO:
			return PedidoService.STATUS_DESC_APROVADO;
		case PedidoService.STATUS_CANCELADO:
			return PedidoService.STATUS_DESC_CANCELADO;
		default:
			return "Status desconhecido";
		}
	}

	public Usuario getUsuario() {
		return pedido.getUsuario();
	}

	public Set<Livro> getLivros() {
		return pedido.getLivros();
	}
}
