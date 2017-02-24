package br.com.livraria.service;

public class ReferencedEntityException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ReferencedEntityException() {
	}

	public ReferencedEntityException(String message) {
		super(message);
	}

	public ReferencedEntityException(Throwable cause) {
		super(cause);
	}

	public ReferencedEntityException(String message, Throwable cause) {
		super(message, cause);
	}
}
