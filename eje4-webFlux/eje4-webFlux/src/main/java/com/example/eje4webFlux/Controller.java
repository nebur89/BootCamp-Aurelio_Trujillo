package com.example.eje4webFlux;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class Controller {

	@GetMapping(path="/numbers", produces="text/event-stream")
	public Flux<Integer> numbers(){
		Flux<Integer> flux=Flux.range(1,30).delayElements(Duration.ofSeconds(1));
		return flux;
	}
	
	
	@GetMapping(path = "/numbers-with-subscribers", produces = "text/event-stream")
	public Flux<Integer> numbersWithSubscribers() {

	Flux<Integer> flux = Flux.range(1, 30).delayElements(Duration.ofSeconds(1));
	
	flux.subscribe(n -> Subscriber.print(n)); 

	flux.subscribe(n -> System.out.println("Subscriber 2: " + n)); 

	return flux; 
	}
}
