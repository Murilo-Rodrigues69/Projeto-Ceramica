package com.ceramicamaster.gerenciador2.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ceramicamaster.gerenciador2.entities.Carregamento;
import com.ceramicamaster.gerenciador2.entities.Forno;
import com.ceramicamaster.gerenciador2.entities.Funcionario;
import com.ceramicamaster.gerenciador2.entities.Lenha;
import com.ceramicamaster.gerenciador2.entities.enums.EnumCarregamento;
import com.ceramicamaster.gerenciador2.entities.enums.EnumLenha;
import com.ceramicamaster.gerenciador2.repositories.CarregamentoRepositer;
import com.ceramicamaster.gerenciador2.repositories.FornoRepositer;
import com.ceramicamaster.gerenciador2.repositories.FuncionarioRepositer;
import com.ceramicamaster.gerenciador2.repositories.LenhaRepositer;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@Autowired
	private FuncionarioRepositer funcionarioRepositer;
	
	@Autowired
	private CarregamentoRepositer carregamentorepo;
	
	@Autowired
	private FornoRepositer fornorepo;
	
	@Autowired
	private LenhaRepositer lenharepo;

	@Override
	public void run(String... args) throws Exception {
		Funcionario f1 = new Funcionario(null, "Murilo Oliveira Rodrigues ", LocalDate.parse("26-05-2022", formatter), "61987", "99943", 2500.00);
		Funcionario f2 = new Funcionario(null, "Francisco Rodrigues ",  LocalDate.parse("26-05-2022", formatter), "6122222987", "111", 2670.00);
		
		Carregamento c1 = new Carregamento(null, 7800, "9x19x19",   LocalDate.parse("26-05-2022", formatter), EnumCarregamento.Rodrigo, f2);
		Carregamento c2 = new Carregamento(null, 5600, "11,5x19x19",   LocalDate.parse("26-05-2022", formatter), EnumCarregamento.Pezinho, f1);
		
		Forno fo1 = new Forno(null, 2,  LocalDate.parse("26-05-2022", formatter),  LocalDate.parse("26-05-2022", formatter), "Equipe 5");
		Forno fo2 = new Forno(null, 4,  LocalDate.parse("26-05-2022", formatter),  LocalDate.parse("26-05-2022", formatter), "Equipe 2");
		Forno fo3 = new Forno(null, 6,  LocalDate.parse("26-05-2022", formatter),  LocalDate.parse("26-05-2022", formatter), "Equipe 3");
		
		Lenha l1 = new Lenha(null, "Jose", "Lenha do mato", "RUim", 2.77, 2500.00, EnumLenha.Marcio, LocalDate.parse("26-05-2022", formatter));
		Lenha l2 = new Lenha(null, "Joao", "Lenha do mato", "RUim", 2.77, 2500.00, EnumLenha.Marcio, LocalDate.parse("26-05-2021", formatter));
		Lenha l3 = new Lenha(null, "ze", "Lenha do mato", "RUim", 2.77, 2500.00, EnumLenha.Pezinho, LocalDate.parse("26-05-2025", formatter));
		
		fornorepo.saveAll(Arrays.asList(fo1,fo2,fo3));
		funcionarioRepositer.saveAll(Arrays.asList(f1,f2));
		carregamentorepo.saveAll(Arrays.asList(c1,c2));
		lenharepo.saveAll(Arrays.asList(l1,l2,l3));
	}

  
	
	
}
