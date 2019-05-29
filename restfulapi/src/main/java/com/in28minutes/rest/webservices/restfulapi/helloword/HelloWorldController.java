package com.in28minutes.rest.webservices.restfulapi.helloword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello-word")
	public String getHelloWorld() {
		return "Hello World with Get";
	}

	@GetMapping("/hello-word-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("HelloWorld");
	}

	@GetMapping("/hello-word-bean/path-variable/{name}")
	public HelloWorldBean getHelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
