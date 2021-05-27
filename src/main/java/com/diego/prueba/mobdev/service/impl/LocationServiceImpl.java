package com.diego.prueba.mobdev.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.diego.prueba.mobdev.entities.LocationRequest;
import com.diego.prueba.mobdev.service.ILocationService;

@Service
public class LocationServiceImpl implements ILocationService{

	@Override
	public LocationRequest getlocation(String url) {
		RestTemplate restTemplate = new RestTemplate();
		LocationRequest locacionRequest = restTemplate.getForObject(url, LocationRequest.class);
        return locacionRequest;
	}

	
}
