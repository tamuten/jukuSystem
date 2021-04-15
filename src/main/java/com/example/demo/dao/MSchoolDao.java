package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.object.School;
import com.example.demo.util.SqlReader;

@Repository
public class MSchoolDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void register(School school) {
		jdbcTemplate.update(SqlReader.createSqlString("registerSchool.sql"), getParam(school));
	}

	private Object[] getParam(School school) {
		List<Object> params = new ArrayList<>();

		params.add(school.getSchoolName());
		params.add(school.getSchoolNameKana());
		params.add(school.getSchoolAbbreviatedName());
		params.add(school.getAddress());
		params.add(school.getZipcode());
		params.add(school.getManager());
		params.add(school.isDeleteFlg());
		params.add(school.getUpdateTime());

		return params.toArray();
	}

	public List<School> getAllSchools() {
		RowMapper<School> rowMapper = new BeanPropertyRowMapper<>(School.class);
		return jdbcTemplate.query(SqlReader.createSqlString("selectAllSchools.sql"), rowMapper);
	}
}
