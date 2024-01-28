package com.github.besshutok.crawlerpoc.core.crawler;

import com.norconex.collector.http.HttpCollector;
import com.norconex.collector.http.HttpCollectorConfig;

import java.io.File;

/**
 *
 */
public class PocHttpCollector {

	private final String folderString;

	private final File folder;

	private final HttpCollector collector;

 	public PocHttpCollector( HttpCollectorConfig collectorConfig, String folderString, File folder ) {
		this.folderString = folderString;
		this.folder = folder;
		this.collector = new HttpCollector( collectorConfig );
	}

	public void start() {
		collector.start();
	}
}
