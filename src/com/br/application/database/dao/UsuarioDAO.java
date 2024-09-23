package com.br.application.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.application.database.DB;
import com.br.application.entity.Usuario;

public class UsuarioDAO {

	public void adicionarUsuario(Usuario usuario) {
		String query = "INSERT INTO tb_usuario (name, password) VALUES (?, ?)";

		try (Connection conn = DB.connect();
				PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, usuario.getName());
			stmt.setString(2,usuario.getPassword());

			int rowsAffected = stmt.executeUpdate();
			System.out.println(rowsAffected + " row(s) inserted.");


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkLogin(String login, String senha) {
		String query = "SELECT * FROM tb_usuario WHERE name = ? AND password = ?";
		try (Connection conn = DB.connect();
				PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, login);
			stmt.setString(2, senha);

			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}