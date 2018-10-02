package com.forze.sa.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(BloodTypeRepository bloodTypeRepository,GenderRepository genderRepository){
		return args -> {
			Stream.of("A","B","AB","O").forEach(type ->{
				BloodTypeEntity bloodType = new BloodTypeEntity();
				bloodType.setName(type);
				bloodTypeRepository.save(bloodType);
			});
			Stream.of("male","female").forEach(type ->{
				GenderEntity gender = new GenderEntity();
				gender.setName(type);
				genderRepository.save(gender);
			});
		};
	}
}
