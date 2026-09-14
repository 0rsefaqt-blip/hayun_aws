package kr.fast.diary.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.fast.diary.entity.EmotionTag;
import kr.fast.diary.service.EmotionTagService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class HomeController {
	
	private final EmotionTagService emotionTagService;
	
	@GetMapping("/a")
	public ResponseEntity<Object> home(){
		List<EmotionTag> list = emotionTagService.findAll();
		return ResponseEntity.ok(list);
	}

}
