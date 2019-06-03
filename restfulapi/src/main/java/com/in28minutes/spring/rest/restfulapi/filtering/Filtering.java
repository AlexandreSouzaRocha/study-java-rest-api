package com.in28minutes.spring.rest.restfulapi.filtering;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class Filtering {

	public static MappingJacksonValue mappingJacksonValueFiltering(FilterProvider filterProvider,
			SimpleBeanPropertyFilter filter, List<SomeBean> someBean) {

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;

	}

}
