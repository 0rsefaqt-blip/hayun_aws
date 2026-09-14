package kr.fast.diary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.fast.diary.entity.EmotionTag;
import kr.fast.diary.repository.EmotionTagRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmotionTagService {

	private final EmotionTagRepository emotionTagRepository;

	public List<EmotionTag> findAll() {
		return emotionTagRepository.findAll();
	}
}
