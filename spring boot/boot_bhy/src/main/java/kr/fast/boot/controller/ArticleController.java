package kr.fast.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.fast.boot.dto.ArticleDTO;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ArticleController {

	
	/* ArticleController
	 * 컨트롤러 추가
	 * 메서드 추가
	 * url:/article/1
	 * 리턴: "1번 게시글입니다"
	 */
	//@GetMapping("/article/1")
	//@ResponseBody
	//public String article() {
	//		return "1번 기사입니다.";
	//}
	
	//             자료명           변수명
	private final UserController userController;
	
	// 생성자이름(클래스이름과같)  타입         변수명    
	//                이 타입에 변수명의 변수를 생성자가 전달받는다
	ArticleController(UserController userController) { //생성자
		//this.현재 이 객체 내 생성자의 변수
		//                    생성자가 받은 변수(밖에서 전달받은)
		this.userController = userController;
	}

	@GetMapping("/article/{num}")
	@ResponseBody
	public String article(@PathVariable("num")int articleNum) { //패스베리얼 url상의 값을 가져올때
		return articleNum + "번 기사입니다.";
	}
	
	@GetMapping("/article1")
	@ResponseBody
	public String articles1(
			@RequestParam("search")String search,
			@RequestParam(value="page", required=false, defaultValue = "1")int page) {
		log.info("방법1");
		log.info("검색어 : "+search );
		log.info("페이지 : "+page );
		return "검색 결과입니다.";
	}
	
	@GetMapping("/article2")
	@ResponseBody
	public String articles2(@RequestParam Map<String, Object> map) {
		log.info("방법2");
		log.info("검색어 : "+map.get("search") );
		log.info("페이지 : "+map.get("page") );
		return "검색 결과입니다.";
	}
	
	@GetMapping("/article3")
	@ResponseBody
	public String articles3(ArticleDTO dto) {
		log.info("방법3");
		log.info("검색어 : "+dto.getSearch());
		log.info("페이지 : "+dto.getPage());
		return "검색 결과입니다.";
	}
	
	@GetMapping("/article/list1")
	@ResponseBody
	public Map<String, Object> articleList1() {
		// 객체 . 맵은 새로운 객체를 부르는이름 뉴 뒤에 해쉬맵은 클래스
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("writer", "홍길동");
		map.put("article", "기사내용입니다.");
		return map;
	}
	
	@GetMapping("/article/list2")
	@ResponseBody
	public ArrayList<String> articleList2() {
		ArrayList<String> articles = new ArrayList<String>();
		articles.add("기사1");
		articles.add("기사2");
		articles.add("기사3");
		return articles;
	}
	
	@GetMapping("/article/list3")
	@ResponseBody
	public ResponseEntity<Object> articleList3() {
		ArticleDTO dto = new ArticleDTO();
		dto.setSearch("기사");
		return ResponseEntity.ok(dto);
	}
	
}
