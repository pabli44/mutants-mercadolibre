package com.pvelilla.mutantes.MutantesProject.config.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

import java.util.ArrayList;
import java.util.List;

public class DozerMappingBuilder {

	private final DozerBeanMapper dozerBeanMapper;

	public DozerMappingBuilder() {
		this.dozerBeanMapper = dozerBeanMapper();
	}

	private DozerBeanMapper dozerBeanMapper() {
		List<String> mappingFiles = new ArrayList<>();
		mappingFiles.add("dozerJdk8Converters.xml");

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFiles);
		mapper.addMapping(beanMappingBuilder());
		return mapper;
	}

	public <T> T map(Object source, Class<T> destinationClass) {
		return dozerBeanMapper.map(source, destinationClass);
	}

	private BeanMappingBuilder beanMappingBuilder() {
		return new BeanMappingBuilder() {

			@Override
			protected void configure() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

}
