package com.project.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.dashboard.model.Role;
import com.project.dashboard.model.User;
import com.project.dashboard.repository.UserRepository;

public class CustomRunner implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
			
			  User userExists=userRepository.findByEmail("admin@gmail.com");
				if(userExists==null) {
					User admin=new User();
					admin.setFirstName("admin");
					admin.setEmail("admin@gmail.com");
					admin.setPassword(passwordEncoder.encode("password"));
					admin.addRole(new Role("Admin"));
					userRepository.save(admin);
				}
		
	}
}
