package com.epicode.progettofinaleepicode.auth.runners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.epicode.progettofinaleepicode.auth.entity.ERole;
import com.epicode.progettofinaleepicode.auth.entity.Role;
import com.epicode.progettofinaleepicode.auth.entity.Utente;
import com.epicode.progettofinaleepicode.auth.repository.RoleRepository;
import com.epicode.progettofinaleepicode.auth.repository.UserRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Component
public class UtenteRunner implements ApplicationRunner {


	
	RoleRepository roleRepository;
	UserRepository userRepository;
	PasswordEncoder encoder;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role admin = new Role();
		admin.setRoleName( ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName( ERole.ROLE_USER);
		roleRepository.save(user);
		
		Set<Role> ruoliAdministrator = new HashSet<Role>();
		ruoliAdministrator.add(admin);
		
		Utente userAdmin  = new Utente();
		userAdmin.setUsername("craigbauer89");

		userAdmin.setPassword(encoder.encode("qwerty"));
//		userAdmin.setNome("Timmy");
//		userAdmin.setEmail("timmyv@gmail.com");
//		userAdmin.setCognome("Verde");
		userAdmin.setRoles(ruoliAdministrator);
		userRepository.save(userAdmin);
		
		Set<Role> ruoliUtente = new HashSet<Role>();
		ruoliUtente.add(user);
		
		Utente simpleUser = new Utente();
		simpleUser.setUsername("user1");
//		simpleUser.setNome("gianluigi");
//		simpleUser.setEmail("gianluigi@gmail.com");
//		simpleUser.setCognome("Marrone");
		simpleUser.setPassword( encoder.encode("qwerty"));

		simpleUser.setRoles(ruoliUtente);
		userRepository.save(simpleUser);
		
		
//		Utente simpleUser2 = new Utente();
//		simpleUser2.setUsername("user1");
//		simpleUser2.setPassword( encoder.encode("qwerty"));
//		userRepository.save(simpleUser2);
		
		
		
		
		
		
		
		
	}
}
