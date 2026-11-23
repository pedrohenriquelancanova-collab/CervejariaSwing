package controller;

import cervejaria.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Cerveja;

public class CervejaController {

    private Connection conexao;

    public CervejaController() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(Cerveja c) {
        String sql = "insert into cad_cerveja "
                + "(nome_cerveja, tipo_estilo, teor_alcoolico, IBU, pais_origem, fabricante, data_degustacao, local_degustacao, avaliacao) "
                + "values (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, c.getNome_cerveja());
            stmt.setString(2, c.getTipo_estilo());
            stmt.setString(3, c.getTeor_alcoolico());
            stmt.setString(4, c.getIBU());
            stmt.setString(5, c.getPais_origem());
            stmt.setString(6, c.getFabricante());
            stmt.setDate(7, c.getData_degustacao());
            stmt.setString(8, c.getLocal_degustacao());
            stmt.setDouble(9, c.getAvaliacao());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Cerveja> listar() {
        String sql = "select * from cad_cerveja";

        try {
            LinkedList<Cerveja> cervejas = new LinkedList<Cerveja>();

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
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

    public LinkedList<Cerveja> procurar(String nome_cerveja) {
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

    public Cerveja procurar(int id) {
        String sql = "select * from cad_cerveja where id = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
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

    public void alterar(Cerveja c) {
        String sql = "update cad_cerveja set "
                + "nome_cerveja=?, tipo_estilo=?, teor_alcoolico=?, IBU=?, "
                + "pais_origem=?, fabricante=?, data_degustacao=?, "
                + "local_degustacao=?, avaliacao=? where id=?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, c.getNome_cerveja());
            stmt.setString(2, c.getTipo_estilo());
            stmt.setString(3, c.getTeor_alcoolico());
            stmt.setString(4, c.getIBU());
            stmt.setString(5, c.getPais_origem());
            stmt.setString(6, c.getFabricante());
            stmt.setDate(7, c.getData_degustacao());
            stmt.setString(8, c.getLocal_degustacao());
            stmt.setDouble(9, c.getAvaliacao());
            stmt.setInt(10, c.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Cerveja c) {
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
