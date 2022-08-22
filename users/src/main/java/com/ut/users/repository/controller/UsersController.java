package com.ut.users.repository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ut.users.model.Users;
import com.ut.users.repository.UsersRepository;

@RestController
@RequestMapping("users/rest") // http://localhost:8080
public class UsersController {

	@Autowired
	private UsersRepository usersRepo;
	
	@GetMapping("/all")
	public ResponseEntity<List<Users>> getAllUsers() {
		
		List<Users> allUsers = usersRepo.findAll();
		
		return new ResponseEntity<List<Users>>(allUsers,HttpStatus.OK);
	}
	
	@GetMapping("/status={status}")
	public ResponseEntity<List<Users>> getStatus(@PathVariable String status) {
		
		List<Users> userStatus = usersRepo.findByStatus(status);
		
		return new ResponseEntity<List<Users>>(userStatus,HttpStatus.OK);
	}
	
	@GetMapping("/levelGreaterThan{lvl}")
	public ResponseEntity<List<Users>> getLevelGreaterThan(@PathVariable int lvl) {
		
		List<Users> usersLevel = usersRepo.findByLevelGreaterThan(lvl);
		
		return new ResponseEntity<List<Users>>(usersLevel,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
		
		usersRepo.save(user);
		
		Users newUser = usersRepo.findByUserId(user.getUserId());
		
		return  new ResponseEntity<Users>(newUser,HttpStatus.OK);
	}
	
	@PutMapping("/update/userId={uid}")
	public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable("uid") int uid) {
		
		user.setUserId(uid);
		
		usersRepo.save(user);
		
		Users updatedUser = usersRepo.findByUserId(user.getUserId());
		
		return new ResponseEntity<Users>(updatedUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/userId={uid}")
	public ResponseEntity<String> deleteUser(@PathVariable("uid") int uid) {
		
		usersRepo.deleteByUserId(uid);
		
		return new ResponseEntity<String>("user deleted",HttpStatus.OK);
	}
}
