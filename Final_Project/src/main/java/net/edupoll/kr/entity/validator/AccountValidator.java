package net.edupoll.kr.entity.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.edupoll.kr.entity.AccountVo;

public class AccountValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AccountVo.class.isAssignableFrom(clazz);
	}

	
	@Override
	public void validate(Object target, Errors errors) {
		AccountVo vo = (AccountVo) target;	
		if(vo.getUserId() == null) {
			errors.rejectValue("userId", "required");
		}else {
			if(vo.getUserId().length() <3) {
				errors.rejectValue("userId", "length");
			}
		}
		
		if(vo.getUserName() == null) {
			errors.rejectValue("userName", "required");
		}else {
			if(!vo.getUserName().matches("[가-힇]{2,5}") ) {
				errors.rejectValue("userName", "invalid");
			}
		}
	}
}









