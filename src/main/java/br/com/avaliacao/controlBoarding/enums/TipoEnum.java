package br.com.avaliacao.controlBoarding.enums;

public enum TipoEnum {
	
	BOARDING(1L),
	LANDING(2L);
	
	private Long valor;
	
	TipoEnum(long valor) {
		this.valor = valor;
	}
	
	public Long getValor() {
		return this.valor;
	}
	

}
