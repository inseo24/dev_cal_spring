package dev.cal.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import dev.cal.handler.ex.CustomValidationException;
import dev.cal.web.dto.CMResponseDto;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CustomValidationException.class)
	public CMResponseDto<Map<String, String>> validationException(CustomValidationException e) {
		return new CMResponseDto(-1 ,e.getMessage(), e.getErrorMap());
	}
	
}
