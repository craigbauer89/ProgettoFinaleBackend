package com.epicode.progettofinaleepicode.auth.service;



import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.epicode.progettofinaleepicode.auth.entity.Role;
import com.epicode.progettofinaleepicode.auth.entity.UserResponse;
import com.epicode.progettofinaleepicode.auth.entity.Utente;
import com.epicode.progettofinaleepicode.auth.repository.RoleRepository;
import com.epicode.progettofinaleepicode.auth.repository.UserRepository;
import com.epicode.progettofinaleepicode.entity.Squadre;

import lombok.AllArgsConstructor;




@Service
@AllArgsConstructor

public class UserService {

	private UserRepository  userRepository;
	
	
	private RoleRepository  roleRepository;
	
	PasswordEncoder encoder;
	
	public List<Utente> getAll() {
		return userRepository.findAll();
	}
	

	public Utente insert(Utente user) {
		if(userRepository.existsById(user.getId())) {
			throw new EntityExistsException("User gia inserito");
		}
		Role role = roleRepository.findById((long) 2).get();
		
		Set <Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
		
	}
	

		public void cancella(Long id) {
			if (!userRepository.existsById(id)) {
				throw new EntityNotFoundException("User not trovato");
			}
			
			userRepository.deleteById(id);
		}
		
		
		public List<UserResponse> getAllUsersBasicInformations() {
			return userRepository.findAll()
					.stream()
					.map( user ->  UserResponse
									.builder()
									.userName(  user.getUsername()  )
									.role( user.getRoles().stream().findFirst().get().getRoleName().name() )
									.build()   
					).collect(Collectors.toList());
		}
		
		public UserResponse getUserBasicInformations(String userName) {
			Utente user = userRepository.findByUsername(userName).get();
			
			
			
			return UserResponse
			.builder()
			.userName(userName)
			.role( user.getRoles().stream().findFirst().get().getRoleName().name()).build();
			
		}

}



