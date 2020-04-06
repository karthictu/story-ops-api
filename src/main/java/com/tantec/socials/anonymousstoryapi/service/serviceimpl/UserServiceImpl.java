package com.tantec.socials.anonymousstoryapi.service.serviceimpl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.tantec.socials.anonymousstoryapi.service.UserService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired RestTemplate restTemplate;

    private static final String userApiBaseUrl = "http://user";

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Map<String, Object> getUserById(String userId) {
        HttpHeaders headers = new HttpHeaders();
		URI url = null;
		try {
			url = new URI(UriComponentsBuilder.fromUriString(userApiBaseUrl + "/" + userId).toUriString());
		} catch (URISyntaxException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
        }
        
        HttpEntity<String> request = new HttpEntity<String>("", headers);
        
        Map<String, Object> responseBody = null;
        try {
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
            responseBody = (Map<String, Object>) response.getBody();
        } catch (HttpClientErrorException e) {
            LOGGER.info(e.getLocalizedMessage(), e);
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                responseBody = new HashMap<String, Object>();
            } 
        }
        

		return responseBody;
    }

}