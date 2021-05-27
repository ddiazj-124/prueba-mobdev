package com.diego.prueba.mobdev.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diego.prueba.mobdev.entities.CharacterRequest;
import com.diego.prueba.mobdev.entities.ErrorResponse;
import com.diego.prueba.mobdev.entities.LocationRequest;
import com.diego.prueba.mobdev.entities.RootResponse;
import com.diego.prueba.mobdev.service.IRootService;
import com.diego.prueba.mobdev.service.impl.CharacterServiceImpl;
import com.diego.prueba.mobdev.service.impl.LocationServiceImpl;
import com.diego.prueba.mobdev.service.impl.RootServiceImpl;

@RestController
@RequestMapping("api/")
public class RootController {
	
	@Autowired
	private CharacterServiceImpl characterService;
	
	@Autowired
    private IRootService rootService;

	@GetMapping(value = "getRoot/{id}")
    public ResponseEntity<?> getRoot(@PathVariable(value = "id") int id) {
		RootResponse rootResponse = rootService.getRootResponse(id);
        return new ResponseEntity<RootResponse>(rootResponse,HttpStatus.OK);
    }
	
	
	@GetMapping(value = "getCharacter/{id}")
    public CharacterRequest getCharacter(@PathVariable(value = "id") int id) {
		
        CharacterRequest response = characterService.getCharacter(id);
        return response; //ResponseEntity.ok(response);
    }
	
	
}
