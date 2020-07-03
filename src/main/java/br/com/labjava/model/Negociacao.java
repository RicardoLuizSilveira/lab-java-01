package br.com.labjava.model;

import java.time.LocalDateTime;

public final class Negociacao {

	private final Double preco;
	private final Integer quantidade;
	private final LocalDateTime data;

	public Negociacao(Double preco, Integer quantidade, LocalDateTime data) {
		validacao(preco, quantidade, data);
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	private void validacao(Double preco, Integer quantidade, LocalDateTime data) {
		if (preco < 0.0)
			throw new IllegalArgumentException("O preco não pode ser negativo");
		if (quantidade < 1)
			throw new IllegalArgumentException("A quantidade deve ser positiva");
		if (data == null)
			throw new IllegalArgumentException("A data não pode ser nula");
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
