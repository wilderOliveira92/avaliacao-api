package br.com.avaliacao.controlBoarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avaliacao.controlBoarding.model.Boarding;
import br.com.avaliacao.controlBoarding.service.AlterarBoardingService;
import br.com.avaliacao.controlBoarding.service.CadastrarBoardingService;
import br.com.avaliacao.controlBoarding.service.ConsultarBoardingService;

@RestController
@RequestMapping("/boarding")
public class BoardingController {

	@Autowired
	private CadastrarBoardingService cadastrarService;
	@Autowired
	private AlterarBoardingService alterarService;
	@Autowired
	private ConsultarBoardingService consultarService;
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("Funcionou!");
		return "Hello World";
	}
	
	@PostMapping("/cadastrar")
	public Boarding cadastrar(@RequestBody Boarding boarding) throws Exception {
		return cadastrarService.execute(boarding);
	}
	
	@PutMapping("/alterar")
	public Boarding alterar(@RequestBody Boarding boarding) throws Exception {
		return alterarService.execute(boarding);
	}
	
	@GetMapping("/listar")
	public List<Boarding> listar() throws Exception {
		return consultarService.execute();
	}
	
	
}
