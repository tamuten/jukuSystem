package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.object.Lesson;

@Mapper
public interface LessonMapper {
	public boolean insert(Lesson lesson);

	public Lesson selectOne(String id);

	public List<Lesson> selectMany();
}
