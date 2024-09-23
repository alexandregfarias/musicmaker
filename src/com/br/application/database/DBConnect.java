package com.br.application.database;

import java.sql.SQLException;

public class DBConnect {

	public static void connect() {
		try (var connection =  DB.connect()){
			System.out.println("Connected to the PostgreSQL database.");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}