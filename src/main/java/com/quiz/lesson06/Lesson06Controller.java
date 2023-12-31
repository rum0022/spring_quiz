package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookMarkBo;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {

	@Autowired
	private BookMarkBo bookMarkBo;
	
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 입력 수행 - AJAX 통신요청 => 응답값은 무조건 String이다.!(제이슨도 스트링이다) [{"키":value,...}]
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		//insert db
		bookMarkBo.addBookmark(name, url);
		
		// ["{"code번호":200, "result":"성공"}"]
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result; // map => json String
	}
	
	//즐겨찾기 목록 화면
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmarkView(Model model) {
		// select db
		List<Bookmark> bookmarkList = bookMarkBo.getBookmarkList();
		// model에 담기
		model.addAttribute("bookmarkList", bookmarkList);
		return "lesson06/afterAddBookmark";
	}
	
	//URL중복확인 - AJAX 요청
	@ResponseBody
	@PostMapping("is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url) {
		
		//db select요청 (중복이다, 아니다)
		boolean isDuplication = bookMarkBo.isDuplicationUrl(url);
		
		//결과
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		return result; // map => json String
		
	}
	
	//즐겨찾기 삭제 - AJAX
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id) {
		
		//db delete
		int rowCount = bookMarkBo.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200); //성공
			result.put("result", "성공");
		} else {
			result.put("code", 500); //실패
			result.put("error_message", "삭제하는데 실패했습니다.");
		}
		return result;
	}
}
