package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	/*
	 * ResponseEntity é o tipo especifico do Spring para retornar respostas de
	 * requisições web. O ResponseEntity espera um tipo de reposta, que será a
	 * classe Product. No return esperamos que ele retorne um ResponseEntity.ok(para
	 * retornar a resposta com sucesso no http). E então chamamos o .body para
	 * retornar ao corpo da resposta esse usuário que foi instanciado
	 */
	
	@Autowired
	private ProductService service; 
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
