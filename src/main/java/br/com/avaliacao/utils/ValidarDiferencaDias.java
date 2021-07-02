package br.com.avaliacao.utils;

import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ValidarDiferencaDias {
	
	public Long calcularDiferencaDias(Date data1, Date data2) {
				
		Long diferencaDias = ChronoUnit.DAYS.between(data1.toInstant(), data2.toInstant());
		return diferencaDias; 
	}

}
