package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	/*
	 * ResponseEntity é o tipo especifico do Spring para retornar respostas de
	 * requisições web. O ResponseEntity espera um tipo de reposta, que será a
	 * classe Category. No return esperamos que ele retorne um ResponseEntity.ok(para
	 * retornar a resposta com sucesso no http). E então chamamos o .body para
	 * retornar ao corpo da resposta esse usuário que foi instanciado
	 */
	
	@Autowired
	private CategoryService service; 
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		//Category u = new Category(1L, "Maria", "maria@gmail.com","9999999", "12345");
		List<Category> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
