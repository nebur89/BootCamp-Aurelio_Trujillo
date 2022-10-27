package com.example.webfluxappmicro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;


@Controller
public class PersonServiceController {

	@Autowired
	PersonService personService;
	
	
	 
	@GetMapping("/person-list")
	public String personList(final Model model){
		final Flux <Person> personList=  personService.allPersons();
		
		model.addAttribute("personList", personList);
		return "personList";
	}
	
	
}
