package util;

import java.sql.*;

public class ConnectionDB {

    Connection con = null;
    PreparedStatement stmt; //Acessa a tabela;
    ResultSet rs; // Consulta a Tabela;
    CallableStatement call; //Procedures e Function

    public void open() throws Exception {

        String url = "jdbc:mysql://localhost:3306/cadastros";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar com o banco");
        }
    }

    public void close() throws Exception {
        con.close();

    }
}
