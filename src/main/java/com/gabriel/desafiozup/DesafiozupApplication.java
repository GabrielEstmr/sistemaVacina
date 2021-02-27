package com.gabriel.desafiozup;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabriel.desafiozup.domain.User;
import com.gabriel.desafiozup.domain.Vaccine;
import com.gabriel.desafiozup.repositories.UserRepository;
import com.gabriel.desafiozup.repositories.VaccineRepository;




@SpringBootApplication
public class DesafiozupApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VaccineRepository vaccineRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafiozupApplication.class, args);
	}

	//Block to run variables
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Date bday1 = new Calendar.Builder()
		    .setDate(2012, 2, 21)
		    .setTimeOfDay(14, 0, 0)
		    .build().getTime();
		User user1 = new User(null,"Gabriel Rodrigues","gabriel.estmr@gmail.com","100.182.976-09",bday1);

		Date bday2 = new Calendar.Builder()
		    .setDate(2012, 2, 21)
		    .setTimeOfDay(14, 0, 0)
		    .build().getTime();	
		User user2 = new User(null,"Bernardo Rodrigues","bernardo@gmail.com","999.182.976-09",bday2);
		userRepository.saveAll(Arrays.asList(user1,user2));
		
		Date admDate1 = new Calendar.Builder()
			    .setDate(2021, 2, 10)
			    .setTimeOfDay(14, 0, 0)
			    .build().getTime();	
		Date admDate2 = new Calendar.Builder()
			    .setDate(2021, 2, 21)
			    .setTimeOfDay(14, 0, 0)
			    .build().getTime();	
		Vaccine v1 = new Vaccine(null, "CoronaVac", admDate1, user1);
		Vaccine v2 = new Vaccine(null, "CoronaVac", admDate2, user1);
		
		Date admDate3 = new Calendar.Builder()
			    .setDate(2021, 2, 1)
			    .setTimeOfDay(14, 0, 0)
			    .build().getTime();	
		Vaccine v3 = new Vaccine(null, "Astrazeneca", admDate3, user2);
		
		vaccineRepository.saveAll(Arrays.asList(v1,v2,v3));
		
	}
	


}
