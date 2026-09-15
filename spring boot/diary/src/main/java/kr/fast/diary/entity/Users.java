package kr.fast.diary.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.fast.diary.dto.UserDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {


	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name="user_id")
	   private Long userId;
	   
	   private String email;
	   
	   private String password;
	   
	   private String nickname;

	   @Column(name = "created_at", nullable = false)
	   LocalDateTime createdAt = LocalDateTime.now();

	   public Users(String email, String password, String nickname) {
		   this.email = email;
		   this.password = password;
		   this.nickname = nickname;
	   }
}