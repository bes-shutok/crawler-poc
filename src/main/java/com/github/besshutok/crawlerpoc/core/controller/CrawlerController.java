package com.github.besshutok.crawlerpoc.core.controller;

import com.norconex.collector.http.HttpCollector;
import com.norconex.collector.http.HttpCollectorConfig;
import com.norconex.collector.http.crawler.HttpCrawlerConfig;
import com.norconex.commons.lang.config.ConfigurationLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *   API to manage crawler
 */
@RestController
@RequestMapping( path = "/crawler")
public class CrawlerController {

	private final ConfigurationLoader configurationLoader;
	private final HttpCollectorConfig collectorConfig;
	private final ClassLoader classLoader;

	public CrawlerController( ) {
		this.configurationLoader = new ConfigurationLoader();
		this.collectorConfig = new HttpCollectorConfig();
		this.classLoader = getClass().getClassLoader();
	}

	@PostMapping( path = "/start" )
	public ResponseEntity<Object> start( ) throws URISyntaxException {
		final Path configFile = Paths.get(classLoader.getResource( "crawler-config/config.xml" ).toURI());
		configurationLoader.loadFromXML(configFile, collectorConfig);
		collectorConfig.setId( "test" );
		collectorConfig.setMaxConcurrentCrawlers( 20 );
		final HttpCollector collector = new HttpCollector(collectorConfig);
		collector.start();
		return ResponseEntity.accepted().build();
	}
}
