package com.diego.prueba.mobdev.business.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.prueba.mobdev.business.IRootService;
import com.diego.prueba.mobdev.entities.response.CharacterResponse;
import com.diego.prueba.mobdev.entities.response.LocationResponse;
import com.diego.prueba.mobdev.entities.response.OriginResponse;
import com.diego.prueba.mobdev.entities.response.GetCharacterResponse;
import com.diego.prueba.mobdev.repository.ICharacterRepository;
import com.diego.prueba.mobdev.repository.ILocationRepository;

@Service
public class RootServiceImpl implements IRootService{
	
	@Autowired
    private ICharacterRepository characterService;

    @Autowired
    private ILocationRepository locationService;

	@Override
	public GetCharacterResponse getCharacter(Integer id) {
		LocationResponse location = new LocationResponse();
        CharacterResponse character = characterService.getCharacter(id);
        if(character.getOrigin().getUrl().length()>0) {
        	location = locationService.getlocation(character.getOrigin().getUrl());
        }else {
        	location.setDimension("unknown");
        	location.setResidents(new ArrayList<String>());
        }
        
        OriginResponse originResponse = new OriginResponse(character.getOrigin().getName() ,character.getOrigin().getUrl() ,location.getDimension(), location.getResidents());
        
        GetCharacterResponse rootResponse = new GetCharacterResponse(character.getId(), 
        											character.getName(), 
        											character.getStatus(), 
        											character.getSpecies(), 
        											character.getType(), 
        											character.getEpisode().size(),
        											originResponse);
        return rootResponse;
	}

}
