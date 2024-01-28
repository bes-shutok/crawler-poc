package com.github.besshutok.crawlerpoc.utils;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Slf4j
public class EnvironmentPropertiesPrinter {

	@Autowired
	private Environment env;

	@PostConstruct
	public void print() {
		log.info( "Environment properties:" );
		log.info( "logger.folder: {}", env.getProperty( "logging.folder" ) );
		log.info( "logger.level: {}", env.getProperty( "logging.level.root" ) );
	}

}
