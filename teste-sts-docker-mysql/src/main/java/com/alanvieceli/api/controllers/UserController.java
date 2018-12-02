package com.alanvieceli.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alanvieceli.api.domains.User;
import com.alanvieceli.api.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService serv;
	
	@PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User user)
    {
		User obj = serv.salvar(user);
		return ResponseEntity.ok().body(obj);
    }


    @GetMapping("/users")
    public ResponseEntity<?> findAll()
    {
    	List<User> lista = serv.listarTodos();
    	return ResponseEntity.ok().body(lista);
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User userObj)
    {
    	User obj =  serv.atualizar(id, userObj);
    	return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id)
    {    	
    	List<User> lista = serv.excluir(id);
    	return ResponseEntity.ok().body(lista);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable("id") Long id)
    {    	
    	User obj = serv.buscarPorId(id);
    	return ResponseEntity.ok().body(obj);
    }

}
