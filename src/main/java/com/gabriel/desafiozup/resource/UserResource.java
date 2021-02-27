package com.gabriel.desafiozup.resource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.desafiozup.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> listar() {
		
		Date bday1 = new Calendar.Builder()
			    .setDate(2012, 2, 21)
			    .setTimeOfDay(14, 0, 0)
			    .build().getTime();
		User user1 = new User(1,"Gabriel Rodrigues","gabriel.estmr@gmail.com","100.182.976-09",bday1);
		
		Date bday2 = new Calendar.Builder()
			    .setDate(2012, 2, 21)
			    .setTimeOfDay(14, 0, 0)
			    .build().getTime();	
		User user2 = new User(2,"Bernardo Rodrigues","bernardo@gmail.com","999.182.976-09",bday1);
		
		
		List<User> lista = new ArrayList<>();
		lista.add(user1);
		lista.add(user2);
		
		return lista;
	}

}
