package com.alanvieceli.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanvieceli.api.domains.User;
import com.alanvieceli.api.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User salvar(User user) {
		return repo.save(user);		
	}
	
	public List<User> listarTodos(){
		return repo.findAll();
	}
	
	public User atualizar(Long id, User userObj) {
        Optional<User> user = repo.findById(id);        
        if (user.isPresent()) {
	        user.get().setName(userObj.getName());
	        user.get().setCountry(userObj.getCountry());
        }
        return repo.save(user.get());
	}
	
	public List<User> excluir(Long id){
		Optional<User> user = repo.findById(id);        
        if (user.isPresent()) {
        	repo.deleteById(id);
        }
        return listarTodos();
	}
	
	public User buscarPorId(Long id) {
		Optional<User> user = repo.findById(id);
		return user.get();
	}
	
}
