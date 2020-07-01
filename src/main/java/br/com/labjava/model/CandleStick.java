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
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.maximo = maximo;
		this.minimo = minimo;
		this.volume = volume;
		this.data = data;
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
