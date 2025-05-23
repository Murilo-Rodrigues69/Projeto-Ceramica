package com.ceramicamaster.gerenciador2.config;

import java.time.Instant;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ceramicamaster.gerenciador2.entities.Carregamento;
import com.ceramicamaster.gerenciador2.entities.Funcionario;
import com.ceramicamaster.gerenciador2.entities.enums.EnumCarregamento;
import com.ceramicamaster.gerenciador2.repositories.CarregamentoRepositer;
import com.ceramicamaster.gerenciador2.repositories.FuncionarioRepositer;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{


	
	@Autowired
	private FuncionarioRepositer funcionarioRepositer;
	
	@Autowired
	private CarregamentoRepositer carregamentorepo;

	@Override
	public void run(String... args) throws Exception {
		Funcionario f1 = new Funcionario(null, "Murilo Oliveira Rodrigues ", Instant.now(), "61987", "99943", 2500.00);
		Funcionario f2 = new Funcionario(null, "Francisco Rodrigues ", Instant.now(), "6122222987", "111", 2670.00);
		
		Carregamento c1 = new Carregamento(null, 7800, "9x19x19",  Instant.parse("2019-06-20T19:53:07Z"), EnumCarregamento.Rodrigo, f2);
		Carregamento c2 = new Carregamento(null, 5600, "11,5x19x19",  Instant.parse("2019-07-21T03:42:10Z"), EnumCarregamento.Pezinho, f1);
		
		funcionarioRepositer.saveAll(Arrays.asList(f1,f2));
		carregamentorepo.saveAll(Arrays.asList(c1,c2));
	}

  
	
	
}
