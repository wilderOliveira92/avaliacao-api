package br.com.avaliacao.controlBoarding.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.avaliacao.controlBoarding.model.Boarding;
import br.com.avaliacao.controlBoarding.repository.BoardingRepository;

@Service
public class CadastrarBoardingService {
	
	@Autowired
	private BoardingRepository boardingRepository;
	
	@Autowired
	private ValidarBoardingService validarService;

	
	public Boarding execute(Boarding boarding) throws Exception {
		try {
			
			validarService.execute(boarding);
			
			return boardingRepository.save(boarding);
			
		} catch (Exception e) {
			throw new Exception("Erro ao cadastrar boarding: " + e.getMessage());
		}
	}
	


}
