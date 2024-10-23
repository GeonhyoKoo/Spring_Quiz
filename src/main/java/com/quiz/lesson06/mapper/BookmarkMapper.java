package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {

	
	public List<Bookmark> selectBookmarkList();
	
	
	public void insertBookmarkList(
			@Param("name") String name,
			@Param("url") String url
			);
	
	
	public boolean isDuplicatedUrl(String url);
	
	
	
	//input : url
	//output :  Bookmark
	public List<Bookmark> selectBookmarkByUrl(String url);
	
	
	public int deleteBookmarkById(int id); 
	
	
}
