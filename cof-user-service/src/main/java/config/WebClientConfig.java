package config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
public class WebClientConfig {
	
	private static final String FRAUrl = "http://localhost:8082/api/activity";
	
	/*
	 * @Bean
	 * 
	 * @LoadBalanced public WebClient.Builder webClientBuilder() { return
	 * WebClient.builder(); }
	 */
	
	 @Bean
	 @LoadBalanced
	    public WebClient getWebClient() {
	        return WebClient.builder()
	                .clone()
	                .baseUrl(FRAUrl)
	                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	                .build();
	    }
}
