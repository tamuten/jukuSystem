package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.MSchoolDao;
import com.example.demo.object.School;

@Service
@Transactional
public class SchoolMasterService {
	@Autowired
	private MSchoolDao mSchoolDao;

	public void register(School school) {
		mSchoolDao.register(school);
	}

	public List<School> getAllSchools() {
		return mSchoolDao.getAllSchools();
	}
}