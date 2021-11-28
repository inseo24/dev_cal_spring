package dev.cal.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cal.domain.member.Member;
import dev.cal.handler.ex.CustomValidationException;
import dev.cal.service.AuthService;
import dev.cal.web.dto.CMResponseDto;
import dev.cal.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
	 
	private final AuthService authService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> signupForm(@RequestBody @Valid SignupDto signupDto, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			
			throw new CustomValidationException("유효성 검사 실패", errorMap);
			
		} else {
	
			log.info(signupDto.toString());	
			Member member = signupDto.toEntity(); 
			log.info(member.toString());
			Member memberEntity = authService.signup(member);
			CMResponseDto response = new CMResponseDto(1, null, null);
			
			return ResponseEntity.ok().body(response);
		}
		
		
	}
}
