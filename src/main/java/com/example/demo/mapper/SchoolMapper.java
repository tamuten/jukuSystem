package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.object.School;

@Mapper
public interface SchoolMapper {

	@Select("SELECT * FROM m_school")
	List<School> selectAll();

}
