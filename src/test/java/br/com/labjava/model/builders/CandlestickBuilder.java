package br.com.labjava.model.builders;

import java.time.LocalDateTime;

import br.com.labjava.model.CandleStick;

public class CandlestickBuilder {

	private Double abertura;
	private Double fechamento;
	private Double maximo;
	private Double minimo;
	private Double volume;
	private LocalDateTime data;
	
	public Double getAbertura() {
		return abertura;
	}
	public CandlestickBuilder setAbertura(Double abertura) {
		this.abertura = abertura;
		return this;
	}
	public Double getFechamento() {
		return fechamento;
	}
	public CandlestickBuilder setFechamento(Double fechamento) {
		this.fechamento = fechamento;
		return this;
	}
	public Double getMaximo() {
		return maximo;
	}
	public CandlestickBuilder setMaximo(Double maximo) {
		this.maximo = maximo;
		return this;
	}
	public Double getMinimo() {
		return minimo;
	}
	public CandlestickBuilder setMinimo(Double minimo) {
		this.minimo = minimo;
		return this;
	}
	public Double getVolume() {
		return volume;
	}
	public CandlestickBuilder setVolume(Double volume) {
		this.volume = volume;
		return this;
	}
	public LocalDateTime getData() {
		return data;
	}
	public CandlestickBuilder setData(LocalDateTime data) {
		this.data = data;
		return this;
	}
	
	public CandleStick build() {
		return new CandleStick(abertura, fechamento, maximo, minimo, volume, data);
	}
	

}
