package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	/*
	 * ResponseEntity é o tipo especifico do Spring para retornar respostas de
	 * requisições web. O ResponseEntity espera um tipo de reposta, que será a
	 * classe User. No return esperamos que ele retorne um ResponseEntity.ok(para
	 * retornar a resposta com sucesso no http). E então chamamos o .body para
	 * retornar ao corpo da resposta esse usuário que foi instanciado
	 */
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com","9999999", "12345");
		return ResponseEntity.ok(u);
	}

}
