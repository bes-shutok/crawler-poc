package com.github.besshutok.crawlerpoc.core.controller;

import com.github.besshutok.crawlerpoc.core.ControllerIntegrationTestConfiguration;
import com.github.besshutok.crawlerpoc.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration test for {@link CrawlerController}
 */
@ActiveProfiles( "integration" )
@ExtendWith( SpringExtension.class )
@WebMvcTest
@Import( ControllerIntegrationTestConfiguration.class )
@Tag( "Integration" )
@Slf4j
class CrawlerControllerIntegrationTest {

	private MockMvc mockMvc;

	@BeforeEach
	void setUp(  WebApplicationContext webApplicationContext ) {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup( webApplicationContext )
				.build();

		try {
			Path targetDir = Paths.get("collector-output/test");
			if ( Files.exists(targetDir)) {
				FileUtils.deleteDirectory(targetDir);
			}
		} catch ( IOException e) {
			throw new RuntimeException("Failed to clean 'target' directory", e);
		}

	}

	@AfterEach
	void tearDown() {
	}

	@Test
	@DisplayName( "Crawler should start" )
	void shouldStart() throws Exception {
		log.info( "Starting test for crawling API" );

		mockMvc.perform( post( "/crawler/start")
						.contentType( MediaType.APPLICATION_JSON )
						.accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isAccepted() )
				.andDo( print() );
	}
}
