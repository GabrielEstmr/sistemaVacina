//package com.gabriel.desafiozup.services.validation;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.gabriel.desafiozup.dto.UserDTO;
//import com.gabriel.desafiozup.repositories.UserRepository;
//import com.gabriel.desafiozup.resource.exception.FieldMessage;
//
//public class UserInsertValidator implements ConstraintValidator<UserInsert, UserDTO> {
//	
//	@Autowired
//	private UserRepository repo;
//	
//	@Override
//	public void initialize(UserInsert ann) {
//	}
//
//	@Override
//	public boolean isValid(UserDTO objDto, ConstraintValidatorContext context) {
//		
//		repo.findByEmail(null)
//		
//		
//		List<FieldMessage> list = new ArrayList<>();
//		
//		if(objDto.getCpf() != null) {
//			list.add(new FieldMessage("tipo", "CPf deve ser unico"));
//		}
//		
//		if(objDto.getEmail() != null) {
//			list.add(new FieldMessage("tipo", "Email deve ser unico"));
//		}
//
//		// inclua os testes aqui, inserindo erros na lista
//
//		for (FieldMessage e : list) {
//			context.disableDefaultConstraintViolation();
//			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldMessage())
//					.addConstraintViolation();
//		}
//		return list.isEmpty();
//	}
//}