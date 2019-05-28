package com.in28minutes.spring.basics.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBasicsApplication {

	public static void main(String[] args) {
<<<<<<< HEAD

		
		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);

=======
		
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(SpringBasicsApplication.class, args);
		
		BinarySearchImpl binarySearch = 
				applicationContext.getBean(BinarySearchImpl.class);
		
		int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
>>>>>>> master
		System.out.println(result);
	}

}
