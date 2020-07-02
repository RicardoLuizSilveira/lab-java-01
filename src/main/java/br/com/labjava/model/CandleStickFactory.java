package br.com.labjava.model;

import java.time.LocalDateTime;
import java.util.List;

public class CandleStickFactory {

	public CandleStick montaCandleStick(List<Negociacao> negociacoes, LocalDateTime data) {

		if (negociacoes.isEmpty()) {
			return new CandleStick(0.0, 0.0, 0.0, 0.0, 0.0, data);
		}

		Double abertura = negociacoes.get(0).getPreco();
		Double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
		Double maximo = abertura;
		Double minimo = abertura;
		Double volume = 0.0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}
		return new CandleStick(abertura, fechamento, maximo, minimo, volume, data);
	}
}
