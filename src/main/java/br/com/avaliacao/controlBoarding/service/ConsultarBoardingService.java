package br.com.avaliacao.controlBoarding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.controlBoarding.model.Boarding;
import br.com.avaliacao.controlBoarding.repository.BoardingRepository;

@Service
public class ConsultarBoardingService {

	@Autowired
	private BoardingRepository boardingRepository;
	
	public List<Boarding> execute() throws Exception {
		try {
			
			return boardingRepository.findAll();
			
		} catch (Exception e) {
			throw new Exception("Erro ao listar boarding: " + e.getMessage());
		}
	}
	
}
