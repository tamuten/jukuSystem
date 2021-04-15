package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentDao;
import com.example.demo.object.Student;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentDao dao;

	public void register(Student student) {
		dao.register(student);
	}

	public Student selectOne(Integer studentId) {
		return dao.selectOne(studentId);
	}

	public List<Student> selectMany() {
		return dao.selectMany();
	}
}
