package com.example.eje2programacionfuncional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Eje2ProgramacionFuncionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Eje2ProgramacionFuncionalApplication.class, args);
		
	
		List<Product> shopping = List.of(
				new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
                new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
                new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
                new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
                new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
                new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));
		
			
		BigDecimal total_compra = shopping.stream()
                .map(x -> x.price.add(x.price.multiply(new BigDecimal(x.tax.percent)).divide(new BigDecimal(100))))
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y)).setScale(2, RoundingMode.CEILING);

		
		System.out.println("El total de la compra es:" + total_compra);
		
		
		 String empiezaPorC=  shopping.stream().filter(x -> x.name.startsWith("c")).sorted().map(x-> x.name).collect(Collectors.joining(", "));
		
		
		
		
	}
	

}
