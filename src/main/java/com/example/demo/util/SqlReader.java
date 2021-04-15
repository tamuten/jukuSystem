package com.example.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;

public class SqlReader {
	public static String createSqlString(String fileName) {

		StringBuilder sb = new StringBuilder();
		String path = "sql/" + fileName;

		try (InputStream is = new ClassPathResource(path).getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

			String sql;
			while ((sql = br.readLine()) != null) {
				sb.append(sql);
				sb.append(" ");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return sb.toString();
	}
}
