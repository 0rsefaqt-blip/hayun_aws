package kr.fast.boot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.fast.boot.dto.BoardDTO;
import kr.fast.boot.entity.Board;
import kr.fast.boot.repository.BoardRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	@Transactional
	public boolean insertBoard(BoardDTO dto) {
		//게시판 이름이 null이거나 빈 문자열이면 false를 리턴 
		//                 게시판 이름                빈 문자열
		if(dto == null || dto.name() == null || dto.name().trim().length() == 0) {
			throw new IllegalArgumentException("잘못된 게시판입니다.");
		}
		//레포지토리야 게시판명이 중복되는지 알려줘. 게시판명을 줄테니
		boolean isExists = boardRepository.existsByName(dto.name());
		if(isExists) {
			throw new IllegalArgumentException("이미 등록된 게시판입니다.");
		}
		//게시판 등록
		//게시판 등록을 위해 엔티티 객체를 생성
		Board board = new Board(dto.name());
		//생성한 엔티티를 저장해서 DB에 추가
		Board insertedBoard = boardRepository.save(board);
		return true;
	}

	public void updateBoard(BoardDTO board) {
		System.out.println("곧 구현 예정");
		
	}
	
}
