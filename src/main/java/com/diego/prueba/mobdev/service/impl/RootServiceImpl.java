package com.diego.prueba.mobdev.service.impl;


import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.prueba.mobdev.entities.CharacterRequest;
import com.diego.prueba.mobdev.entities.LocationRequest;
import com.diego.prueba.mobdev.entities.Origin;
import com.diego.prueba.mobdev.entities.OriginResponse;
import com.diego.prueba.mobdev.entities.RootResponse;
import com.diego.prueba.mobdev.service.ICharacterService;
import com.diego.prueba.mobdev.service.ILocationService;
import com.diego.prueba.mobdev.service.IRootService;

@Service
public class RootServiceImpl implements IRootService{
	
	@Autowired
    private ICharacterService characterService;

    @Autowired
    private ILocationService locationService;

	@Override
	public RootResponse getRootResponse(Integer id) {
		LocationRequest location = new LocationRequest();
        CharacterRequest character = characterService.getCharacter(id);
        if(character.getOrigin().getUrl().length()>0) {
        	location = locationService.getlocation(character.getOrigin().getUrl());
        }else {
        	location.setDimension("unknown");
        	location.setResidents(new ArrayList<String>());
        }
        
        OriginResponse originResponse = new OriginResponse(character.getOrigin().getName() ,character.getOrigin().getUrl() ,location.getDimension(), location.getResidents());
        
        RootResponse rootResponse = new RootResponse(character.getId(), 
        											character.getName(), 
        											character.getStatus(), 
        											character.getSpecies(), 
        											character.getType(), 
        											character.getEpisode().size(),
        											originResponse);
        return rootResponse;
	}

}
