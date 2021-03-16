package com.metadata.databaseview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.metadata.databaseview.api.dao.TableRepository;
import com.metadata.databaseview.api.dao.UserRepository;
import com.metadata.databaseview.api.model.User;
//import com.metadata.databaseview.dto.OrderRequest;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationApplication {
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		repository.save(user);
		return "Hi! Your registration successfully completed";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> findAllUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/findUser/{email}")
	public List<User> findUser(@PathVariable String email) {
		return repository.findByEmail(email);
	}

	@DeleteMapping("/cancel/{id}")
	public List<User> cancelRegistration(@PathVariable int id) {
		repository.deleteById(id);
		return repository.findAll();
	}
	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private TableRepository tableRepository;
//	
//	@PostMapping("/getConnection")
//	public User getConnection(@RequestBody OrderRequest request) {
//		return userRepository.save(request.getUser());
//	}
//	
//	@GetMapping("/findAllConnections")
//	public List<User> findAllConnections(){
//		return userRepository.findAll();
//	}
	
	

}
