package br.com.avaliacao.controlBoarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avaliacao.controlBoarding.model.Boarding;

public interface BoardingRepository extends JpaRepository<Boarding, Long> {
	
	Boarding findFirstByIdFuncionarioAndTipoOrderByDataInicioDesc(Long idFuncionario, Long tipo);
	
}
