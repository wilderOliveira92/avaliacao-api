package br.com.avaliacao.funcionario.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.avaliacao.funcionario.model.Funcionario;
import br.com.avaliacao.funcionario.service.AlterarFuncionarioService;
import br.com.avaliacao.funcionario.service.CadastroFuncionarioService;
import br.com.avaliacao.funcionario.service.ListarFuncionariosService;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	
	@Autowired
	private CadastroFuncionarioService cadastroService;
	
	@Autowired
	private ListarFuncionariosService listarService;
	
	@Autowired
	private AlterarFuncionarioService alterarService;

	@GetMapping("/consultar")
	private List<Funcionario> listar(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date periodoEmbarqueInicial, 
				@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date periodoEmbarqueFinal) throws Exception{
			return listarService.execute(periodoEmbarqueInicial, periodoEmbarqueFinal);		
	}
	
	@PostMapping("/cadastrar")
	private Funcionario cadastrar(@RequestBody Funcionario funcionario) throws Exception {		
		return cadastroService.execute(funcionario);
	}
	
	@PutMapping("/alterar")
	private Funcionario alterar(@RequestBody Funcionario funcionario) throws Exception {
		return alterarService.execute(funcionario);
	}
	
}
