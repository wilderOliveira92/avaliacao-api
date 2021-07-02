package br.com.avaliacao.funcionario.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.funcionario.model.Funcionario;
import br.com.avaliacao.funcionario.repository.FuncionarioRepository;

@Service
public class ListarFuncionariosService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionario> execute(Date periodoEmbarqueInicial, Date periodoEmbarqueFinal) throws Exception  {
		
		try {
			
			if(periodoEmbarqueInicial != null) {
				return funcionarioRepository.findFuncionarioForDateBoarding(periodoEmbarqueInicial, periodoEmbarqueFinal);
			}
			return funcionarioRepository.findAll();
			
		} catch (Exception e) {
			throw new Exception("Erro ao listar funcionários: " + e.getMessage());
		}
		
	}
	
}
