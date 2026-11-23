package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Usuario;
import cervejaria.Conexao;

public class UsuarioContoller {

    private Connection conexao;

    public UsuarioContoller() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(Usuario u) {
        String sql = "insert into login_usuario (nome, email, senha) values (?,?,?)";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Usuario> listar() {
        String sql = "select * from login_usuario";

        try {
            LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );

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

    public LinkedList<Usuario> procurar(String nome) {
        String sql = "select * from login_usuario where nome like ?";

        try {
            LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );

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
        String sql = "select * from login_usuario where id = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );

                u.setId(rs.getInt("id"));

                rs.close();
                stmt.close();

                return u;
            }

            rs.close();
            stmt.close();

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Usuario u) {
        String sql = "update login_usuario set nome=?, email=?, senha=? where id=?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Usuario u) {
        String sql = "delete from login_usuario where id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, u.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
