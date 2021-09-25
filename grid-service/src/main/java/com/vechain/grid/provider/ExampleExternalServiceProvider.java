package com.vechain.grid.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechain.service.FeignService;

@Service
public class ExampleExternalServiceProvider {

	@Autowired
	private FeignService feignService;

	private Logger logger = LoggerFactory.getLogger(ExampleExternalServiceProvider.class);

	

}
