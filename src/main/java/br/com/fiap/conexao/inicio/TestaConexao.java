package br.com.fiap.conexao.inicio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.conexao.database;
import br.com.fiap.conexao.entity.Pessoa;

public class TestaConexao {

	public static void main(String[] args) {

		save(getDados());

		findAll();

	}

	private static Pessoa getDados() {
		Scanner sc = new Scanner(System.in);
		String nome = "";
		String sobrenome = "";

		while (nome.isEmpty()) {
			System.out.println("Informe o nome:");
			nome = sc.nextLine();
		}

		while (sobrenome.isEmpty()) {
			System.out.println("Informe o Sobrenome:");
			sobrenome = sc.nextLine();
		}
		
		sc.close();
		return new Pessoa(null, nome.toUpperCase().trim(), sobrenome.toUpperCase().trim());
	}

	private static void findAll() {

		database db = new database();

		String sql = "select * from pessoa";

		ResultSet rs = db.executeQuery(sql);

		try {
			while (rs.next()) {
				Pessoa p = new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("sobrenome"));
				System.out.println(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	private static void save(Pessoa p) {

		database db = new database();

		// @formatter:off
 		String sql = "insert into pessoa(id, nome, sobrenome) " 
				+ " values( SEQ_PESSOA.nextval"+ ",'" 
 				 +p.getNome() + "','"
				+ p.getSobrenome() + "')";
 		// @formatter:on

		db.executeQuery(sql);

		db.close();
	}
}
