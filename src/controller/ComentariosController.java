/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cervejaria.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Comentarios;

/**
 *
 * @author 2025007300
 */
public class ComentariosController {
    private Connection conexao;

    public ComentariosController() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(Comentarios c) {
        String sql = "insert into come_cerveja "
                + "(sabor, aroma, corpo, aparencia) "
                + "values (?,?,?,?)";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, c.getSabor());
            stmt.setString(2, c.getAroma());
            stmt.setString(3, c.getCorpo());
            stmt.setString(4, c.getAparencia());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Comentarios> listar() {
        String sql = "select * from come_cerveja";

        try {
            LinkedList<Comentarios> comentarios = new LinkedList<Comentarios>();

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Comentarios c = new Comentarios(
                        rs.getString("sabor"),
                        rs.getString("aroma"),
                        rs.getString("corpo"),
                        rs.getString("aparencia")
                );

                c.setId(rs.getInt("id"));

                comentarios.add(c);
            }

            rs.close();
            stmt.close();

            return comentarios;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   /* public LinkedList<Comparacao> procurar(String nome_cerveja) {
        String sql = "select * from cad_cerveja where nome_cerveja like ?";

        try {
            LinkedList<Cerveja> cervejas = new LinkedList<Cerveja>();

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, "%" + nome_cerveja + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cerveja c = new Cerveja(
                        rs.getString("nome_cerveja"),
                        rs.getString("tipo_estilo"),
                        rs.getString("teor_alcoolico"),
                        rs.getString("IBU"),
                        rs.getString("pais_origem"),
                        rs.getString("fabricante"),
                        rs.getDate("data_degustacao"),
                        rs.getString("local_degustacao"),
                        rs.getDouble("avaliacao")
                );

                c.setId(rs.getInt("id"));

                cervejas.add(c);
            }

            rs.close();
            stmt.close();

            return cervejas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    */

    public Comentarios procurar(int id) {
        String sql = "select * from come_cerveja where id = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                 Comentarios c = new Comentarios(
                        rs.getString("sabor"),
                        rs.getString("aroma"),
                        rs.getString("corpo"),
                        rs.getString("aparencia")
                );

                c.setId(rs.getInt("id"));

                rs.close();
                stmt.close();

                return c;
            }

            rs.close();
            stmt.close();

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Comentarios c) {
        String sql = "update con_cerveja set "
                + "(sabor, aroma, corpo, aparencia) "
                + "values (?,?,?,?)";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, c.getSabor());
            stmt.setString(2, c.getAroma());
            stmt.setString(3, c.getCorpo());
            stmt.setString(4, c.getAparencia());
            stmt.setInt(5, c.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Comentarios c) {
        String sql = "delete from come_cerveja where id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, c.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
