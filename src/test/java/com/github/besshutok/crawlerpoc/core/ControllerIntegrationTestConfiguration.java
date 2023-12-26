package com.github.besshutok.crawlerpoc.core;

import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Configuration for controller integration tests
 */
@TestConfiguration
@Import( { WebMvcAutoConfiguration.class,
		JacksonAutoConfiguration.class,
		HttpMessageConvertersAutoConfiguration.class} )
public abstract class ControllerIntegrationTestConfiguration {

}
