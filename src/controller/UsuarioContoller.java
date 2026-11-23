/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Usuario;
import cervejaria.Conexao;

/**
 *
 * @author 2025007300
 */
public class UsuarioContoller {
    private Connection conexao;

	public UsuarioContoller() {
		this.conexao = Conexao.getConexao();
	}

	public void adicionar(Usuario u) {
		String sql = "insert into Usuario (nome, senha, email) values (?,?,?)";

		try {
			// Criação do Prepared Statement para inserção de um novo Usuario
			PreparedStatement stmt = this.conexao.prepareStatement(sql);

			// Setando os valores de acordo com o usuario recebido por parametro
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getSenha());
			stmt.setString(3, u.getEmail());

			// Executa e após fecha
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public LinkedList<Usuario> listar() {
		String sql = "select * from funcionario";
		
		try {
			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto usuario
				Usuario u = new Usuario(rs.getString("nome"), rs.getString("senha"), rs.getString("email"));
				u.setId(rs.getInt("id"));				

				// Adicionando o objeto à lista
				usuarios.add(u);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public LinkedList<Usuario> procurar(String nome) {
		String sql = "select * from funcionario where nome like ?";
				
		try {
			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, '%' + nome + '%');
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {				
				Usuario u = new Usuario(rs.getString("nome"), rs.getString("senha"), rs.getString("email"));
				u.setId(rs.getInt("id"));
				usuarios.add(u);
			}
			rs.close();
			stmt.close();
			return usuarios;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario procurar(int id) {
		String sql = "select * from funcionario where id = ?";
				
		try {			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs != null){
				rs.next();
				Usuario u = new Usuario(rs.getString("nome"), rs.getString("senha"), rs.getString("email"));
				u.setId(rs.getInt("id"));
				rs.close();
				stmt.close();
				return u;
			}			
			return null;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void alterar(Usuario u) {
	    String sql = "update funcionario set nome=?, email=?, cargo=? where id=?";
	    
	    try {
	        PreparedStatement stmt = this.conexao.prepareStatement(sql);
	        stmt.setString(1, u.getNome());
	        stmt.setString(2, u.getSenha());
	        stmt.setString(3, u.getEmail());	        
	        stmt.setLong(4, u.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	
	public void remover(Usuario u) {
		String sql = "delete from funcionario where id = ?";
				
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, u.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
