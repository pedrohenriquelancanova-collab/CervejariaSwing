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
import model.Cerveja;

/**
 *
 * @author 2025007300
 */
public class CervejaController {

    private Connection conexao;

    public CervejaController() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(Cerveja c) {
        String sql = "insert into cad_cerveja (nome, tipo, teorAlcoolico, ibu, paisOrigem, fabricante, data, localDegustacao, avaliacao, comentarios) values (?,?,?,?,?,?,?)";

        try {
            // Criação do Prepared Statement para inserção de um novo cerveja
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            // Setando os valores de acordo com o cerveja recebido por parametro
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTipo());
            stmt.setString(3, c.getTeorAlcoolico());
            stmt.setString(4, c.getIbu());
            stmt.setString(5, c.getPaisOrigem());
            stmt.setString(6, c.getFabricante());
            stmt.setDate(7, c.getData());
            stmt.setString(8, c.getLocalDegustacao());
            stmt.setDouble(9, c.getAvaliacao());
            stmt.setString(10, c.getComentarios());
            stmt.setLong(11, c.getId());
            // Executa e após fecha
            stmt.execute();
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
                // Criando o objeto cerveja
                Cerveja c = new Cerveja(rs.getString("nome"), rs.getString("tipo"), rs.getString("teorAlcoolico"), rs.getString("ibu"), rs.getString("paisOrigem"), rs.getString("fabricante"),
                                        rs.getDate("data"), rs.getString("localDegustacao"), rs.getDouble("avaliacao"), rs.getString("comentarios"));
                c.setId(rs.getInt("id"));

                // Adicionando o objeto à lista
                cervejas.add(c);
            }
            rs.close();
            stmt.close();
            return cervejas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Cerveja> procurar(String nome) {
        String sql = "select * from cad_cerveja where nome like ?";

        try {
            LinkedList<Cerveja> cervejas = new LinkedList<Cerveja>();
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, '%' + nome + '%');
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cerveja c = new Cerveja(rs.getString("nome"), rs.getString("tipo"), rs.getString("teorAlcoolico"), rs.getString("ibu"), rs.getString("paisOrigem"), rs.getString("fabricante"),
                                        rs.getDate("data"), rs.getString("localDegustacao"), rs.getDouble("avaliacao"), rs.getString("comentarios"));
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
            if (rs != null) {
                rs.next();
                Cerveja c = new Cerveja(rs.getString("nome"), rs.getString("tipo"), rs.getString("teorAlcoolico"), rs.getString("ibu"), rs.getString("paisOrigem"), rs.getString("fabricante"),
                                        rs.getDate("data"), rs.getString("localDegustacao"), rs.getDouble("avaliacao"), rs.getString("comentarios"));
                c.setId(rs.getInt("id"));
                rs.close();
                stmt.close();
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Cerveja c) {
        String sql = "update cad_cerveja set nome=?, email=?, cargo=? where id=?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTipo());
            stmt.setString(3, c.getTeorAlcoolico());
            stmt.setString(4, c.getIbu());
            stmt.setString(5, c.getPaisOrigem());
            stmt.setString(6, c.getFabricante());
            stmt.setDate(7, c.getData());
            stmt.setString(8, c.getLocalDegustacao());
            stmt.setDouble(9, c.getAvaliacao());
            stmt.setString(10, c.getComentarios());
            stmt.setLong(11, c.getId());
            stmt.execute();
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
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
