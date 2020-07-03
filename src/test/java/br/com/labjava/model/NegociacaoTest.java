package br.com.labjava.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class NegociacaoTest {

	LocalDateTime data = LocalDateTime.now();
	
	@Test
	public void testPrecoNaoPodeSerNegativo() {
		assertThrows(IllegalArgumentException.class, 
					() -> new Negociacao(-1.0, 1, data),
					"Should throw IllegalArgumentException but didn't");
	}
	
	@Test
	public void testQuantidadeNaoPodeSerNegativa() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Negociacao(1.0, -1, data),
				"Should throw IllegalArgumentException but didn't");
	}
	
	@Test
	public void testQuantidadeNaoPodeSerZero() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Negociacao(1.0, 0, data),
				"Should throw IllegalArgumentException but didn't");
	}
	
	@Test
	public void testDataNaoPodeSerNula() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Negociacao(1.0, 1, null),
				"Should throw IllegalArgumentException but didn't");
	}

}
