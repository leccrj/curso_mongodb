package com.dudu.cursomongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dudu.cursomongodb.domain.User;
import com.dudu.cursomongodb.dto.UserDTO;
import com.dudu.cursomongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResources {

	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	//@GetMapping (maneira alternativa)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
