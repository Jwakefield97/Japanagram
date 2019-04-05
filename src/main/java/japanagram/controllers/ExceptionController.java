package japanagram.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

	@GetMapping("/exception")
	public String exception() {
		throw new IllegalStateException("Sorry!");
	}

	@GetMapping("/global-exception")
	public String businessException() throws IllegalStateException {
		throw  new IllegalStateException("Sorry!");
	}

	@ExceptionHandler
	public String handle(IllegalStateException e) {
		return "IllegalStateException handled!";
	}

}
