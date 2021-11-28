package dev.cal.web.dto.auth;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dev.cal.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupDto {
	
	@NotBlank(message="이름이 공백입니다.")
	@Size(min=2, max = 10, message = "이름은 2자 이상 10자 이하여야 합니다." )
	private String name;
	
	@NotBlank(message="비밀번호가 공백입니다.")
	private String password;
	
	@NotBlank(message="휴대폰 번호가 공백입니다.")
	private String mobileNum;
	
	@NotBlank(message="이메일이 공백입니다.")
	private String email;
	
	
	public Member toEntity() {
		return Member.builder()
				.name(name)
				.password(password)
				.mobileNum(mobileNum)
				.email(email)
				.build();
	}
}
