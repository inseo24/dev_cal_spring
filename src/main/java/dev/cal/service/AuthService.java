package dev.cal.service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.cal.domain.member.Member;
import dev.cal.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {

	private final MemberRepository memberRepo;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Transactional
	public Member signup(Member member) {
		String rawPassword = member.getPassword();
		String encPasswrod = bCryptPasswordEncoder.encode(rawPassword);
		member.setPassword(encPasswrod);
		Member memberEntity = memberRepo.save(member);
		
		return memberEntity;
	}
}
