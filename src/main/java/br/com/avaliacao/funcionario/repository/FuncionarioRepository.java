package br.com.avaliacao.funcionario.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.funcionario.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	Funcionario findByNomeAndEmpresa(String nome, String empresa);
	
	@Query(value = "SELECT new br.com.avaliacao.funcionario.model.Funcionario( f.id, f.nome, f.funcao, f.empresa ) "
			+ " from Funcionario f"
			+ " inner join Boarding b "
			+ "		on f.id = b.idFuncionario"
			+ " where b.dataInicio between :dataIni and :dataFim"			
			)
	List<Funcionario> findFuncionarioForDateBoarding(@Param("dataIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date periodoEmbarqueInicial, 
			@Param("dataFim") @DateTimeFormat(pattern = "yyyy-MM-dd") Date periodoEmbarqueFinal);

}
