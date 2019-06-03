package com.in28minutes.spring.rest.restfulapi.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		List<SomeBean> listBean = Arrays.asList(new SomeBean("value 1", "value 2", "value 3"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1", "field2");

		FilterProvider filterProvider = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
		
		return Filtering.mappingJacksonValueFiltering(filterProvider, filter, listBean);
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListSomeBeans() {
		List<SomeBean> listBean = Arrays.asList(new SomeBean("value 1", "value 2", "value 3"),
				new SomeBean("Value 11", "value 12", "value 13"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1", "field2");
		

		FilterProvider filterProvider = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);

		return Filtering.mappingJacksonValueFiltering(filterProvider, filter, listBean);
	}

}
