package br.com.avaliacao.funcionario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.funcionario.model.Funcionario;
import br.com.avaliacao.funcionario.repository.FuncionarioRepository;

@Service
public class CadastroFuncionarioService {
	
	private static final String FUNCIONARIO_JA_CADASTRADO = "Funcionário já está cadastrado.";
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario execute(Funcionario funcionario) throws Exception {
		try {
			
			Funcionario findFuncionario = funcionarioRepository.findByNomeAndEmpresa(funcionario.getNome(), funcionario.getEmpresa());
			
			if(findFuncionario != null) {
				throw new Exception(FUNCIONARIO_JA_CADASTRADO);
			}
			
			return funcionarioRepository.save(funcionario);
			
		} catch (Exception e) {
			throw new Exception("Erro ao cadastrar funcionário: " + e.getMessage());
		}
	}

}
