package dev.cal.domain.member;



import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	Member findByEmail(String email);
	
	
}
