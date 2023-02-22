package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	/*
	 * ResponseEntity é o tipo especifico do Spring para retornar respostas de
	 * requisições web. O ResponseEntity espera um tipo de reposta, que será a
	 * classe Order. No return esperamos que ele retorne um ResponseEntity.ok(para
	 * retornar a resposta com sucesso no http). E então chamamos o .body para
	 * retornar ao corpo da resposta esse usuário que foi instanciado
	 */
	
	@Autowired
	private OrderService service; 
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		//Order u = new Order(1L, "Maria", "maria@gmail.com","9999999", "12345");
		List<Order> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
