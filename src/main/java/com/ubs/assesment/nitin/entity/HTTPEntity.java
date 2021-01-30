package com.ubs.assesment.nitin.entity;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ubs.assesment.nitin.dto.LoginDTO;

/**
 * The Class HTTPEntity.
 */
@Component
public class HTTPEntity {

	/** The validate token URI. */
	@Value("${validate.token.uri}")
	private String validateTokenURI;

	/** The rest template. */
	private RestTemplate restTemplate;

	/**
	 * Setup.
	 */
	@PostConstruct
	public void setup() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(30000);
		factory.setConnectTimeout(30000);
		restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(factory);
	}

	/**
	 * Validate token.
	 *
	 * @param token the token
	 * @return the login DTO
	 */
	public LoginDTO validateWithExternalAPI(String token) {
		ResponseEntity<LoginDTO> response = restTemplate.exchange(validateTokenURI,
				HttpMethod.POST, createRequestEntity(token), LoginDTO.class);
		return response.getBody();
	}

	/**
	 * Creates the request entity.
	 *
	 * @param request the request
	 * @return the http entity
	 */
	private static HttpEntity<?> createRequestEntity(String request) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_XML);
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return new HttpEntity<>(request, header);
	}
}
