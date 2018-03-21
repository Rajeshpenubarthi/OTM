package com.overtamilmatrinmony.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.overtamilmatrinmony.core.dto.Reference;
import com.overtamilmatrinmony.core.dto.User;
import com.overtamilmatrinmony.core.dto.UserDetail;
import com.overtamilmatrinmony.core.mailer.service.MailerServices;
import com.overtamilmatrinmony.core.service.UserService;

@RestController
public class UserController
	{

		@Autowired
		private UserService userService;

		@Autowired
		private MailerServices mailService;

		/*
		 * ---Add new book---
		 * 
		 * @PostMapping("/user") public ResponseEntity<?> addUser(@RequestBody User
		 * user) { System.out.println(user.toString());
		 * 
		 * long id = userService.save(user); return
		 * ResponseEntity.ok().body("New User has been saved with ID:" + id); }
		 */

		@PostMapping("/register")
		public ResponseEntity<?> registorUser(@RequestBody User user)
			{
				System.out.println(user.toString());

				long id = 0;
				try {
					id = userService.registorUser(user);
					user.setUserId(id);
					mailService.sendWelcomeMail(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
				return ResponseEntity.ok().body("New User has been saved with ID:" + id);
			}

		@PutMapping("/editreference/{id}")
		public ResponseEntity<?> editReference(@RequestBody List<Reference> reference, @PathVariable("id") int id)
			{
				System.out.println(reference.toString());

				try {
					userService.editReference(reference, id);

				} catch (Exception e) {
					// TODO: handle exception
				}
				return ResponseEntity.ok().body("New User has been saved with ID:" + id);
			}

		@PutMapping("/edituserdetails/{id}")
		public ResponseEntity<?> editUserdetails(@RequestBody UserDetail userdetail, @PathVariable("id") int id)
			{
				System.out.println(userdetail.toString());

				try {
					userService.editUserDetails(userdetail, id);

				} catch (Exception e) {
					// TODO: handle exception
				}
				return ResponseEntity.ok().body("New User has been saved with ID:" + id);
			}
		
		/*---Get a book by id---*/
		@GetMapping("/user/{id}")
		public ResponseEntity<User> get(@PathVariable("id") long id)
			{
				User user = userService.get(id);
				return ResponseEntity.ok().body(user);
			}
	}