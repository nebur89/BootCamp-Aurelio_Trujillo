package com.example.webfluxappmicro;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class PersonController {
	@GetMapping("/person-list1")
	public Flux<Person> personList1(){
		Flux<Person> flux = Flux.just(new Person("Juan", "Juanito", 18)).delayElements(Duration.ofSeconds(4));
		return flux;
	}
	
	@GetMapping("/person-list2")
	public Flux<Person> personList2(){
		Flux<Person> flux = Flux.just(new Person("Pepe", "PePito", 30)).delayElements(Duration.ofSeconds(3));
		return flux;
	}
	
	@GetMapping("/person-list3")
	public Flux<Person> personList3(){
		Flux<Person> flux = Flux.just(new Person("Manolo", "manolito", 14)).delayElements(Duration.ofSeconds(2));
		return flux;
	}
	
	@GetMapping("/person-list4")
	public Flux<Person> personList4(){
		Flux<Person> flux = Flux.just(new Person("Maria", "Marinita", 32)).delayElements(Duration.ofSeconds(1));
		return flux;
	}
	
	
}