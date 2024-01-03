package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookMarkBo {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	//input : url     output : boolean
	public boolean isDuplicationUrl(String url) {
		// 중복이 없음:[] 비어있는 리스트가됨, 중복이면 리스트는 채워져서 리턴됨.
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		return bookmarkList.isEmpty() ? false : true; 
		//return !bookmarkList.isEmpty(); // false
	}
	
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
}
