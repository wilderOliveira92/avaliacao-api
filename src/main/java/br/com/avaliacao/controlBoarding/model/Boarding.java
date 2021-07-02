package br.com.avaliacao.controlBoarding.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Boarding {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long idFuncionario;
		
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(foreignKey = @ForeignKey(name = "idFuncionario"), name = "idFuncionario")
//	private Funcionario funcionario;
	
	@Column
	private Long tipo;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;
		
	
	public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id = id;
	}
//	public Funcionario getFuncionario() {
//		return funcionario;
//	}
//	public void setFuncionario(Funcionario funcionario) {
//		this.funcionario = funcionario;
//	}
	public Long getTipo() {
		return tipo;
	}
	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	
	

}
