package br.com.labjava.model;

import java.time.LocalDateTime;

public final class Negociacao {
	
	private final Double preco;
	private final Integer quantidade;
	private final LocalDateTime data;

	public Negociacao(Double preco, Integer quantidade, LocalDateTime data) {
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public LocalDateTime getData() {
		return data;
	}
	
	public Double getVolume() {
		return getPreco() * getQuantidade();
	}

}
