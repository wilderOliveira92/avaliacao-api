package br.com.avaliacao.funcionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column
	private String funcao;
	
	@Column
	private String empresa;
	
	
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	public Funcionario(Long id, String nome, String funcao, String empresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.empresa = empresa;
	}

//	@OneToMany(mappedBy = "funcionario")
//	@JsonIgnore
//	private List<Boarding> boardings;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	

}
