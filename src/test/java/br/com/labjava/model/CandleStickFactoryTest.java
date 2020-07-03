package br.com.labjava.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class CandleStickFactoryTest {

	@Test
	public void testBasicoVariasNegociacoes() {
		LocalDateTime data = LocalDateTime.now();
		Negociacao n1 = new Negociacao(40.0, 10, data);
		Negociacao n2 = new Negociacao(20.0, 10, data);
		Negociacao n3 = new Negociacao(10.0, 10, data);
		Negociacao n4 = new Negociacao(50.0, 10, data);
		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);
		
		CandleStickFactory factory = new CandleStickFactory();
		CandleStick candleStick = factory.montaCandleStick(negociacoes, data);
		
		assertEquals(40.0, candleStick.getAbertura(), 0.0001);
		assertEquals(50.0, candleStick.getFechamento(), 0.0001);
		assertEquals(50.0, candleStick.getMaximo(), 0.0001);
		assertEquals(10.0, candleStick.getMinimo(), 0.0001);
		assertEquals(1200.0, candleStick.getVolume(), 0.0001);
		
	}
	
	@Test
	public void testUmaUnicaNegociacao() {
		LocalDateTime data = LocalDateTime.now();
		Negociacao n1 = new Negociacao(40.0, 10, data);
		List<Negociacao> negociacoes = Arrays.asList(n1);
		
		CandleStickFactory factory = new CandleStickFactory();
		CandleStick candleStick = factory.montaCandleStick(negociacoes, data);
		
		assertEquals(40.0, candleStick.getAbertura(), 0.0001);
		assertEquals(40.0, candleStick.getFechamento(), 0.0001);
		assertEquals(40.0, candleStick.getMaximo(), 0.0001);
		assertEquals(40.0, candleStick.getMinimo(), 0.0001);
		assertEquals(400.0, candleStick.getVolume(), 0.0001);
		
	}
	
	@Test
	public void testZeroNegociacoes() {
		LocalDateTime data = LocalDateTime.now();
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		
		CandleStickFactory factory = new CandleStickFactory();
		CandleStick candleStick = factory.montaCandleStick(negociacoes, data);
		
		assertEquals(0.0, candleStick.getAbertura(), 0.0001);
		assertEquals(0.0, candleStick.getFechamento(), 0.0001);
		assertEquals(0.0, candleStick.getMaximo(), 0.0001);
		assertEquals(0.0, candleStick.getMinimo(), 0.0001);
		assertEquals(0.0, candleStick.getVolume(), 0.0001);
		
		assertTrue(!candleStick.isAlta());
		assertTrue(!candleStick.isBaixa());
		
	}
	
	@Test
	public void testCandlestickDeAlta() {
		LocalDateTime data = LocalDateTime.now();
		Negociacao n1 = new Negociacao(20.0, 10, data);
		Negociacao n2 = new Negociacao(40.0, 10, data);
		List<Negociacao> negociacoes = Arrays.asList(n1, n2);
		
		CandleStickFactory factory = new CandleStickFactory();
		CandleStick candleStick = factory.montaCandleStick(negociacoes, data);
		
		assertTrue(candleStick.isAlta(), "O candlestick não era de alta");
		
	}
	
	@Test
	public void testCandlestickDeBaixa() {
		LocalDateTime data = LocalDateTime.now();
		Negociacao n1 = new Negociacao(20.0, 10, data);
		Negociacao n2 = new Negociacao(10.0, 10, data);
		List<Negociacao> negociacoes = Arrays.asList(n1, n2);
		
		CandleStickFactory factory = new CandleStickFactory();
		CandleStick candleStick = factory.montaCandleStick(negociacoes, data);
		
		assertTrue(candleStick.isBaixa(), "O candlestick não era de baixa");
		
	}
	

}












