package br.com.labjava.model;

import java.time.LocalDateTime;

import org.junit.Test;

public class NegociacaoTest {

	LocalDateTime data = LocalDateTime.now();
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrecoNaoPodeSerNegativo() {
		new Negociacao(-1.0, 1, data);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testQuantidadeNaoPodeSerNegativa() {
		new Negociacao(1.0, -1, data);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testQuantidadeNaoPodeSerZero() {
		new Negociacao(1.0, 0, data);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDataNaoPodeSerNula() {
		new Negociacao(1.0, 1, null);
	}

}
