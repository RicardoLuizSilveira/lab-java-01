package br.com.labjava.model;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import br.com.labjava.model.builders.CandlestickBuilder;

public class CandleStickTest {

	@Test(expected = IllegalArgumentException.class)
	public void testDataNaoPodeSerNula() {
		new CandlestickBuilder()
				.setAbertura(40.0)
				.setFechamento(20.0)
				.setMaximo(60.0)
				.setMinimo(10.0)
				.setData(null)
				.setVolume(600.0)
				.build();
	}
	
	@Test
	public void testValorAberturaNaoPodeSerNula() {
		try {
			new CandlestickBuilder()
			.setAbertura(null)
			.setFechamento(20.0)
			.setMaximo(60.0)
			.setMinimo(10.0)
			.setData(LocalDateTime.now())
			.setVolume(600.0)
			.build();
			fail("Deveria ter lancado uma exception: ERRO-05");
		} catch (Exception e) {
			assertTrue("A exception não continha o erro ERRO-05", e.getMessage().contains("ERRO-05"));
		}
	}

}
