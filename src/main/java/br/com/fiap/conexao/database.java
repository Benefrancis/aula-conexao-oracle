package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {

	protected Connection conn;

	protected Statement stmt;

	public database() {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection open() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean executeUpdate(String sql) {
		conn = open();
		try {
			Statement stmt = conn.createStatement();
			if (stmt.executeUpdate(sql) > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet executeQuery(String sql) {
		conn = open();
		try {
			Statement stmt = conn.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
