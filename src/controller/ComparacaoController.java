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
import model.Comparacao;

/**
 *
 * @author 2025007300
 */
public class ComparacaoController {

    private Connection conexao;

    public ComparacaoController() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(Comparacao c) {
        String sql = "insert into con_cerveja "
                + "(nome_cerveja, tipo_estilo, teor_alcoolico, IBU, pais_origem, fabricante, avaliacao_atribuia, cer_id) "
                + "values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, c.getNome_cerveja());
            stmt.setString(2, c.getTipo_estilo());
            stmt.setString(3, c.getTeor_alcoolico());
            stmt.setString(4, c.getIBU());
            stmt.setString(5, c.getPais_origem());
            stmt.setString(6, c.getFabricante());
            stmt.setString(7, c.getAvaliacao_atribuia());
            stmt.setInt(8, c.getCer_id());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Comparacao> listar() {
        String sql = "select * from con_cerveja";

        try {
            LinkedList<Comparacao> comparacoes = new LinkedList<Comparacao>();

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Comparacao c = new Comparacao(
                        rs.getString("nome_cerveja"),
                        rs.getString("tipo_estilo"),
                        rs.getString("teor_alcoolico"),
                        rs.getString("IBU"),
                        rs.getString("pais_origem"),
                        rs.getString("fabricante"),
                        rs.getString("avaliacao_atribuia"),
                        rs.getInt("cer_id")
                );

                c.setId(rs.getInt("id"));

                comparacoes.add(c);
            }

            rs.close();
            stmt.close();

            return comparacoes;

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

    public Comparacao procurar(int id) {
        String sql = "select * from con_cerveja where id = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                 Comparacao c = new Comparacao(
                        rs.getString("nome_cerveja"),
                        rs.getString("tipo_estilo"),
                        rs.getString("teor_alcoolico"),
                        rs.getString("IBU"),
                        rs.getString("pais_origem"),
                        rs.getString("fabricante"),
                        rs.getString("avaliacao_atribuia"),
                        rs.getInt("cer_id")
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

    public void alterar(Comparacao c) {
        String sql = "update con_cerveja set "
                + "nome_cerveja=?, tipo_estilo=?, teor_alcoolico=?, IBU=?, "
                + "pais_origem=?, fabricante=?, avaliacao_atribuia=?, "
                + "cer_id=? where id=?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, c.getNome_cerveja());
            stmt.setString(2, c.getTipo_estilo());
            stmt.setString(3, c.getTeor_alcoolico());
            stmt.setString(4, c.getIBU());
            stmt.setString(5, c.getPais_origem());
            stmt.setString(6, c.getFabricante());
            stmt.setString(7, c.getAvaliacao_atribuia());
            stmt.setInt(8, c.getCer_id());
            stmt.setInt(9, c.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Comparacao c) {
        String sql = "delete from cad_cerveja where id = ?";

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
