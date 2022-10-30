package com.research.project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.research.project.security.entity.CheckEntity;
import com.research.project.security.entity.RoleEntity;
import com.research.project.security.entity.UserEntity;
import com.research.project.security.repository.CheckRepository;
import com.research.project.security.repository.RoleRepository;
import com.research.project.security.repository.UserRepository;

@SpringBootApplication
@CrossOrigin(maxAge = 3600)
public class Application{
	
//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private RoleRepository roleRepository;
//	
//	@Autowired
//	private CheckRepository checkRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		
//		UserEntity user1 = new UserEntity("Md Tarequl", "Islam", "tareq23", "12345678",new BCryptPasswordEncoder().encode("12345678"));
//		UserEntity user2 = new UserEntity("Shariaz", "Muntakim", "shuvo", "12345678", new BCryptPasswordEncoder().encode("12345678"));
//		UserEntity user3 = new UserEntity("Nahid", "Hasan", "nahid", "12345678", new BCryptPasswordEncoder().encode("12345678"));
//		
//		
//		
//		RoleEntity role1 = new RoleEntity("admin", "Admin access all funcationlity");
//		RoleEntity role2 = new RoleEntity("manager","Manager access add or update operation functionality");
//		RoleEntity role3 = new RoleEntity("customer","Customer only access the order product functionality");
//		
//		List<RoleEntity> roles = new ArrayList<RoleEntity>();
//		
//		RoleEntity role = roleRepository.findByName(role1.getName());
//		
//		if(role == null) {
//			roles.add(role1);
//			System.out.println("Role ------------------------   Check "+role);
//		}
//		
//		role = roleRepository.findByName(role2.getName());
//		if(role == null) {
//			roles.add(role2);
//		}
//		role = roleRepository.findByName(role3.getName());
//		if(role == null) {
//			roles.add(role3);
//		}
//		roleRepository.saveAll(roles);
//		
//		user1.getRoles().add(role1);
//		user1.getRoles().add(role2);
//		
//		user2.getRoles().add(role2);
//		user2.getRoles().add(role3);
//		
//		user3.getRoles().add(role3);
//		
//		
//		List<UserEntity> users = new ArrayList<>();
//		
//		UserEntity user = userRepository.findByUsername(user1.getUsername());
//		
//		if(user == null) {
//			users.add(user1);
//		}
//		user = userRepository.findByUsername(user2.getUsername());
//		if(user == null) {
//			users.add(user2);
//		}
//		user = userRepository.findByUsername(user3.getUsername());
//		if(user == null) {
//			users.add(user3);
//		}
//		
//		userRepository.saveAll(users);
//		
//		
//		CheckEntity check1 = new CheckEntity("name 1","address 1");
//		CheckEntity check2 = new CheckEntity("name 2","address 2");
//		CheckEntity check3 = new CheckEntity("name 3","address 3");
//		CheckEntity check4 = new CheckEntity("name 4","address 4");
//		CheckEntity check5 = new CheckEntity("name 5","address 5");
//		
//		List<CheckEntity> checks = Arrays.asList(check1,check2,check3,check4,check5);
//		
//		checkRepository.saveAll(checks);
//		
//	}

}
