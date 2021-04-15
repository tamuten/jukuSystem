package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.object.Student;

@Repository
public class StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void register(Student student) {
		String sql = "insert into student(name, grade) values (?, ?)";
		Object[] param = getParam(student);
		jdbcTemplate.update(sql, param);
	}

	private Object[] getParam(Student student) {
		List<Object> param = new ArrayList<Object>();
		param.add(student.getName());
		param.add(student.getGrade());
		return param.toArray();
	}

	public Student selectOne(Integer studentId) {
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
		String sql = "select * from student where id=?";

		return jdbcTemplate.queryForObject(sql, rowMapper, studentId);
	}

	public List<Student> selectMany() {
		String sql = "select * from student";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);

		return jdbcTemplate.query(sql, rowMapper);
	}
}
