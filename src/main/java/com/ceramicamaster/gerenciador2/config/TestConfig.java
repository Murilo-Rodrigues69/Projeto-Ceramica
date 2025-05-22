package com.ceramicamaster.gerenciador2.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ceramicamaster.gerenciador2.entities.Funcionario;
import com.ceramicamaster.gerenciador2.repositories.FuncionarioRepositer;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{


	private Date data;
	
	@Autowired
	private FuncionarioRepositer funcionarioRepositer;

	@Override
	public void run(String... args) throws Exception {
		Funcionario f1 = new Funcionario(null, "Murilo Oliveira Rodrigues", data, "61982201716", "61991845071", 2500.00);
		Funcionario f2 = new Funcionario(null, "Francisco Rodrigues", data, "61991845071", "61982201716", 10000.00);
		
		funcionarioRepositer.saveAll(Arrays.asList(f1,f2));
	}

  
	
	
}
