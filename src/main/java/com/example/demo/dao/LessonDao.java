package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.LessonMapper;
import com.example.demo.object.Lesson;

@Repository
public class LessonDao {
	@Autowired
	private LessonMapper mapper;

	public void insertOne(Lesson lesson) {
		mapper.insert(lesson);
	}

	public List<Lesson> selectMany() {
		return mapper.selectMany();
	}
}
