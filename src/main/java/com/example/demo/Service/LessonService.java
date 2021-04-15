package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.constants.Sequence;
import com.example.demo.dao.LessonDao;
import com.example.demo.dao.SequenceDao;
import com.example.demo.object.Lesson;

@Service
@Transactional
public class LessonService {
	@Autowired
	private LessonDao lessonDao;
	@Autowired
	private SequenceDao sequenceDao;

	public int getNextId() {
		int nextId = sequenceDao.getSequence(Sequence.LESSON);
		return nextId;
	}

	public void insertOne(Lesson lesson) {
		lessonDao.insertOne(lesson);
	}

	public List<Lesson> selectMany() {
		return lessonDao.selectMany();
	}
}
