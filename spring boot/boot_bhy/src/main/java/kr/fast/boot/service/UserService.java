package kr.fast.boot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.fast.boot.dto.SignupDTO;
import kr.fast.boot.entity.Member;
import kr.fast.boot.repository.MemberRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor //생성자를 자동으로 만들어줌
@Transactional(readOnly = true)
public class UserService {

	private final MemberRepository memberRepository;
	
	@Transactional
	public void signup(SignupDTO dto) {	
		//아이디 체크, 아이디는 최소 3자 이상
		if(dto.getId() == null || dto.getId().length() < 3) {
			throw new IllegalArgumentException("아이디는 3자 이상이어야 합니다.");
		}
		//비번 체크
		if(dto.getPw() == null || dto.getPw().length() < 3) {
			throw new IllegalArgumentException("비번은 3자 이상이어야 합니다.");
		}

		//이메일 체크
		if(dto.getEmail() == null) {
			throw new IllegalArgumentException("이메일은 필수 항목입니다.");
		}

		//아이디 중복검사
		if(memberRepository.existsById(dto.getId())) {
			throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
		}
		
		//이메일 중복검사
		if(memberRepository.existsByEmail(dto.getEmail())) {
			throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
		}

		//비번 암호화
		
		//회원가입
		Member member = new Member(dto.getId(), dto.getPw(), dto.getEmail(), "USER");
		
		Member savemMember = memberRepository.save(member);

		System.out.println(savemMember.getRole());
	}

	
}
