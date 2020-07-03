package br.com.labjava.model;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import br.com.labjava.model.builders.CandlestickBuilder;

@RunWith(JUnitPlatform.class)
public class CandleStickTest {

	@Test
	public void testDataNaoPodeSerNula() {
		IllegalArgumentException ex = assertThrows(
				IllegalArgumentException.class,
	            () -> { new CandlestickBuilder()
		            	.setAbertura(40.0)
		            	.setFechamento(20.0)
		            	.setMaximo(60.0)
		            	.setMinimo(10.0)
		            	.setData(null)
		            	.setVolume(600.0)
		            	.build();
	            },
	            "Deveria ter lancado uma exception: ERRO-04"
	     );
	     assertTrue(ex.getMessage().contains("ERRO-04:"), "Exception não contem o código ERRO-04");
	}
	
	@Test
	public void testValorAberturaNaoPodeSerNula() {
		
		IllegalArgumentException ex = assertThrows(
				IllegalArgumentException.class,
	            () -> { new CandlestickBuilder()
		            	.setAbertura(null)
		            	.setFechamento(20.0)
		            	.setMaximo(60.0)
		            	.setMinimo(10.0)
		            	.setData(LocalDateTime.now())
		            	.setVolume(600.0)
		            	.build();
	            },
	            "Deveria ter lancado uma exception: ERRO-05"
	     );
	     assertTrue(ex.getMessage().contains("ERRO-05"), "A exception não continha o erro ERRO-05");

	}

}
