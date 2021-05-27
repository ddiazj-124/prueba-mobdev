package com.diego.prueba.mobdev.repository.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.diego.prueba.mobdev.entities.response.LocationResponse;
import com.diego.prueba.mobdev.repository.ILocationRepository;

@Service
public class LocationRepositoryImpl implements ILocationRepository{

	@Override
	public LocationResponse getlocation(String url) {
		RestTemplate restTemplate = new RestTemplate();
		LocationResponse locacionRequest = restTemplate.getForObject(url, LocationResponse.class);
        return locacionRequest;
	}

	
}
