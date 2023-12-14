package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {

	// url : http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("rate", 15);
		map1.put("director", "봉준호");
		map1.put("time", 131);
		map1.put("title", "기생충");
		list.add(map1);
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("rate", 0);
		map2.put("director", "로베르토 베니니");
		map2.put("time", 116);
		map2.put("title", "인생은 아름다워");
		list.add(map2);
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("rate", 12);
		map3.put("director", "크리스토퍼 놀란");
		map3.put("time", 147);
		map3.put("title", "인셉션");
		list.add(map3);
		
		Map<String, Object> map4 = new HashMap<>();
		map4.put("rate", 19);
		map4.put("director", "윤종빈");
		map4.put("time", 133);
		map4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		list.add(map4);
		
		Map<String, Object> map5 = new HashMap<>();
		map5.put("rate", 15);
		map5.put("director", "프란시스 로렌스");
		map5.put("time", 137);
		map5.put("title", "헝거게임");
		list.add(map5);
		
		return list; // list<map> JSON 응답
	}	
	
	// url : http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Data> quiz02_2() {
		
		List<Data> list = new ArrayList<>();
		
		Data data1 = new Data();
		data1.setTitle("안녕하세요 가입인사 드립니다.");
		data1.setUser("marobiana");
		data1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		list.add(data1);
		
		Data data2 = new Data();
		data2.setTitle("헐 대박");
		data2.setUser("bada");
		data2.setContent("오늘 목요일이었어... 금요일인줄");
		list.add(data2);
		
		Data data3 = new Data();
		data3.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		data3.setUser("dulumary");
		data3.setContent("...");
		list.add(data3);
		
		return list; // list => json
	}
	
	// 아래내용 두줄로 요약하면?
	// @ResponseBody + return String (두가지가 같이 될때!)=> HttpMessageConverter       =>String ->HTML변환
	// @ResponseBody + return 객체(Map, list, 클래스...) => HttpMessageConverter   jackson라이브러리 => JSON응답
	// 추가내용
	// return String viewResolver -> jsp => HTML
	
	// Request -> Response
	//            @ResponseBody +
	//            return String => HTML
	
	//            jackSon 라이브러리 +
	//            return Map => JSON
	//            return 클래스 => JSON
	//            return list => JSON
	
	// url: http://localhost:8080/lesson01/quiz02/3
		@RequestMapping("/3")
		public ResponseEntity<Data> quiz01_3() {
			Data data = new Data();
			data.setTitle("안녕하세요 가입인사 드립니다.");
			data.setUser("marobiana");
			data.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
			
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
