package com.github.besshutok.crawlerpoc.core.controller;

import com.github.besshutok.crawlerpoc.core.crawler.Committer;
import com.github.besshutok.crawlerpoc.core.crawler.PocHttpCollector;
import com.norconex.collector.http.HttpCollector;
import com.norconex.collector.http.HttpCollectorConfig;
import com.norconex.commons.lang.config.ConfigurationLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *   API to manage crawler
 */
@RestController
@RequestMapping( path = "/crawler")
@Slf4j
public class CrawlerController {

	private final ConfigurationLoader configurationLoader;
	private final PocHttpCollector collector;


	private final ClassLoader classLoader;

	@Autowired
	private Environment env;

	public CrawlerController(
			@Value("${logging.folder}") String folderString,
			@Value("${logging.folder}") File folder
	) throws URISyntaxException {
		final HttpCollectorConfig collectorConfig = new HttpCollectorConfig();
		log.info( "Start synchronous crawling" );
		this.classLoader = getClass().getClassLoader();
		log.info( "Loading configuration from {}", classLoader.getResource( "crawler-config/config.xml" ) );
		final Path configFile = Paths.get(classLoader.getResource( "crawler-config/config.xml" ).toURI());

		this.configurationLoader = new ConfigurationLoader();
		configurationLoader.loadFromXML(configFile, collectorConfig);
		collectorConfig.setId( "test" );
		collectorConfig.setMaxConcurrentCrawlers( 20 );
		collectorConfig.getCrawlerConfigs().stream().flatMap( c -> c.getCommitters().stream() ).forEach(
				c -> {
					if ( c instanceof Committer ) {
						( (Committer) c ).setFolderString( folderString );
						( (Committer) c ).setFolder( folder );
					}
				}
		);

		this.collector = new PocHttpCollector( collectorConfig, folderString, folder );

	}

	@PostMapping( path = "/start" )
	public ResponseEntity<Object> start( ) throws URISyntaxException {
		collector.start();
		return ResponseEntity.accepted().build();
	}
}
