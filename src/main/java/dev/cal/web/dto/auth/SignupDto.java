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
	
	@NotBlank(message="�̸��� �����Դϴ�.")
	@Size(min=2, max = 10, message = "�̸��� 2�� �̻� 10�� ���Ͽ��� �մϴ�." )
	private String name;
	
	@NotBlank(message="��й�ȣ�� �����Դϴ�.")
	private String password;
	
	@NotBlank(message="�޴��� ��ȣ�� �����Դϴ�.")
	private String mobileNum;
	
	@NotBlank(message="�̸����� �����Դϴ�.")
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
