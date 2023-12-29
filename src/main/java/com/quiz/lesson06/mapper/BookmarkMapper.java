package com.quiz.lesson06.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Bookmark;

@Repository
public interface BookmarkMapper {

	public void insertBookmark(String name, String url);
	
	public List<Bookmark> selectBookmark();
}
