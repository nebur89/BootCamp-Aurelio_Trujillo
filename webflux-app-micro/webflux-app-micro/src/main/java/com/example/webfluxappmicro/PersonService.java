package com.example.webfluxappmicro;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class PersonService {

	public Flux<Person> allPersons(){
		
		Flux<Person> per2=WebClient.create("http://localhost:8081/person-list1").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> per1=WebClient.create("http://localhost:8081/person-list1").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> per3=WebClient.create("http://localhost:8081/person-list1").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> per4=WebClient.create("http://localhost:8081/person-list1").get().retrieve().bodyToFlux(Person.class);

		Flux<Person> allFlux=  Flux.merge(per1, per2,per3,per4);
		
		return allFlux;
	}
	
}
