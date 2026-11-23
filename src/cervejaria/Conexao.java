/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cervejaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 2025007300
 */
public class Conexao {
    private Conexao() {}
	
	public static Connection getConexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/cervejaria", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
