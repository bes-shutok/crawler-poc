package com.github.besshutok.crawlerpoc;

import com.github.besshutok.crawlerpoc.core.controller.CrawlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CrawlerPocApplication {

	@Autowired
	private Environment env;

	public static void main( String[] args ) {
		SpringApplication.run( CrawlerPocApplication.class, args );
	}

}
