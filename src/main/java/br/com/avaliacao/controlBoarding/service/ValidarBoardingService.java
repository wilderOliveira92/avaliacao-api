package br.com.avaliacao.controlBoarding.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.controlBoarding.enums.TipoEnum;
import br.com.avaliacao.controlBoarding.model.Boarding;
import br.com.avaliacao.controlBoarding.repository.BoardingRepository;
import br.com.avaliacao.funcionario.model.Funcionario;
import br.com.avaliacao.funcionario.repository.FuncionarioRepository;
import br.com.avaliacao.utils.ValidarDiferencaDias;

@Service
public class ValidarBoardingService {
	
	private static final Long QTD_DIAS_MINIMO_BOARDING = 7L;
	private static final Long QTD_DIAS_MINIMO_LANDING = 14L;
	
	private static final String FUNCIONARIO_NAO_ENCONTRADO = "Funcionário informado não encontrado.";
	private static final String DATA_INICIO_NAO_INFORMADA = "Data inicio não informada.";
	
	@Autowired
	private BoardingRepository boardingRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	
	public void execute(Boarding boarding) throws Exception {
		
		Funcionario findFuncionario = funcionarioRepository.findById(boarding.getIdFuncionario()).orElse(null);
		
		if(findFuncionario == null) {
			throw new Exception(FUNCIONARIO_NAO_ENCONTRADO);
		}
				
		if(boarding.getDataInicio() == null) {
			throw new Exception(DATA_INICIO_NAO_INFORMADA);
		}
					
		if(TipoEnum.BOARDING.getValor() == boarding.getTipo()) {
			validarBoarding(boarding);
		}
		
		if(TipoEnum.LANDING.getValor() == boarding.getTipo()) {
			validarLanding(boarding);
		}
		
	}
	
	private void validarBoarding(Boarding boarding) throws Exception {
		
		Boarding findLanding = boardingRepository.findFirstByIdFuncionarioAndTipoOrderByDataInicioDesc(boarding.getIdFuncionario(), TipoEnum.BOARDING.getValor());
		
		if(findLanding != null) {
				
			ValidarDiferencaDias validaDias = new ValidarDiferencaDias();
			Long diferencaDias  = validaDias.calcularDiferencaDias(findLanding.getDataInicio(), boarding.getDataInicio());
			
			if(diferencaDias <= QTD_DIAS_MINIMO_BOARDING ) {
				throw new Exception("Embarque só pode ser realizado após " + QTD_DIAS_MINIMO_BOARDING.toString() + " dias do desembarque.");
			}
			
		}
		
	}
	
	
	private void validarLanding(Boarding boarding) throws Exception {
		
		Boarding findLanding = boardingRepository.findFirstByIdFuncionarioAndTipoOrderByDataInicioDesc(boarding.getIdFuncionario(), TipoEnum.BOARDING.getValor());
		
		if(findLanding != null) {
				
			ValidarDiferencaDias validaDias = new ValidarDiferencaDias();
			Long diferencaDias  = validaDias.calcularDiferencaDias(findLanding.getDataInicio(), boarding.getDataInicio());
			
			if(diferencaDias <= QTD_DIAS_MINIMO_LANDING ) {
				throw new Exception("Desembarque só pode ser realizado após " + QTD_DIAS_MINIMO_LANDING.toString() + " dias do embarque.");
			}
			
		}
		
	}

}
