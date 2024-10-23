package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	BookmarkMapper bookmarkMapper;
	
	public List<Bookmark> getBookmarkList(){
		return bookmarkMapper.selectBookmarkList();
	}
	
	public void addBookmarkList(String name , String url) {
		bookmarkMapper.insertBookmarkList(name, url);
	}
	
	public boolean isDuplicatedUrl(String url) {
		return bookmarkMapper.isDuplicatedUrl(url);
	}
	
	
	// output
	public boolean isDuplicateUrl(String url) {
		List<Bookmark> bookmarkList	= bookmarkMapper.selectBookmarkByUrl(url);
		
		// 비어 있으면 중복이 아니므로 empty ture -> false
		 return bookmarkList.isEmpty() == false;
	}
	
	
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
	
}
