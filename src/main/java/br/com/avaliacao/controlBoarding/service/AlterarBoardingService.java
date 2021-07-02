package br.com.avaliacao.controlBoarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.controlBoarding.model.Boarding;
import br.com.avaliacao.controlBoarding.repository.BoardingRepository;

@Service
public class AlterarBoardingService {
	
	private static final String EMBARQUE_NAO_ENCONTRADO = "Embarque não encontrado.";

	@Autowired
	private BoardingRepository boardingRepository;
	
	@Autowired
	private ValidarBoardingService validarService;

	
	public Boarding execute(Boarding boarding) throws Exception {
		try {
			
			validarService.execute(boarding);

			Boarding fingBoarding = boardingRepository.findById(boarding.getId()).orElse(null);

			if(fingBoarding == null) {
				throw new Exception(EMBARQUE_NAO_ENCONTRADO);
			}			
			
			fingBoarding.setDataInicio(boarding.getDataInicio());						
			
			return boardingRepository.save(fingBoarding);
			
		} catch (Exception e) {
			throw new Exception("Erro ao alterar embarque: " + e.getMessage());
		}
	}
	
}
