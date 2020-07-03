package br.com.labjava.model;

import java.time.LocalDateTime;

public final class CandleStick {

	private final Double abertura;
	private final Double fechamento;
	private final Double maximo;
	private final Double minimo;
	private final Double volume;
	private final LocalDateTime data;

	public CandleStick(Double abertura, Double fechamento, Double maximo, Double minimo, Double volume,
			LocalDateTime data) {
		validar(data, abertura);
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.maximo = maximo;
		this.minimo = minimo;
		this.volume = volume;
		this.data = data;
	}

	private void validar(LocalDateTime data, Double abertura) {
		if (data == null)
			throw new IllegalArgumentException("A data não pode ser nula");
		if (abertura == null)
			throw new IllegalArgumentException("ERRO-05: O valor da abertura não pode ser nulo");
	}

	public Double getAbertura() {
		return abertura;
	}

	public Double getFechamento() {
		return fechamento;
	}

	public Double getMaximo() {
		return maximo;
	}

	public Double getMinimo() {
		return minimo;
	}

	public Double getVolume() {
		return volume;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Boolean isAlta() {
		return fechamento > abertura;
	}

	public Boolean isBaixa() {
		return fechamento < abertura;
	}
}
