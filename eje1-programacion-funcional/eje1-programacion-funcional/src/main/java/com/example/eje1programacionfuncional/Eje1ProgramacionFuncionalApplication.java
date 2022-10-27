package com.example.eje1programacionfuncional;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Eje1ProgramacionFuncionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Eje1ProgramacionFuncionalApplication.class, args);
		
		
		
		List<Integer> numeros= List.of(18, 6, 4, 15 ,55, 78, 12, 9, 8);
		
		
		Long contador= numeros.stream().filter(num -> num>10).count();
		
		
		System.out.println("Los numeros pares son:" + contador);
		
	}

}
