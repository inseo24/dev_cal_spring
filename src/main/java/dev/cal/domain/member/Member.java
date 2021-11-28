package dev.cal.domain.member;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Member { 
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name ="system-uuid", strategy = "uuid")
	private String id;
	
	@Column(length=25, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String mobileNum;
	
	@Column(unique=true, length=25, nullable = false)
	private String email;
	
	private LocalDateTime createdTime;
	
	
	@PrePersist
	public void createdTime() {
		this.createdTime = LocalDateTime.now();
	}
	
	
}
