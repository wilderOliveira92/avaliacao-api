package br.com.avaliacao.funcionario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.funcionario.model.Funcionario;
import br.com.avaliacao.funcionario.repository.FuncionarioRepository;

@Service
public class AlterarFuncionarioService  {
	
	private static final String FUNCIONARIO_NAO_ENCONTRADO = "Funcionário informado não encontrado.";
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario execute(Funcionario funcionario) throws Exception  {
		
		Optional<Funcionario> optionalFindFuncionario = funcionarioRepository.findById(funcionario.getId());
		
		if(!optionalFindFuncionario.isPresent()) {
			throw new Exception(FUNCIONARIO_NAO_ENCONTRADO);
		}
		
		Funcionario findFuncionario = optionalFindFuncionario.get();		
		findFuncionario.setNome(funcionario.getNome());
		findFuncionario.setEmpresa(funcionario.getEmpresa());
		findFuncionario.setFuncao(funcionario.getFuncao());
		
		return funcionarioRepository.save(funcionario);
	}
	
}
