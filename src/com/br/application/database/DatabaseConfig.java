package com.br.application.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
	private static final Properties properties = new Properties();

	static {
		try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDbUrl() {

		return properties.getProperty("db.url");
	}

	public static String getDbUsername() {
		return properties.getProperty("db.username");
	}

	public static String getDbPassword() {
		return properties.getProperty("db.password");
	}
}