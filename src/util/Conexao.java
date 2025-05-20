package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/appHoelaria";
    private String user = "dbaHotel";
    private String senha = "dbaHotel123";

    public Connection conectar() {
        Connection condb = null;

        try {
            //Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)
            Class.forName(driver);

            //Inicializar o driver já carregado por meio do metodo getConnection(IP, porta, nome do banco, isuario, senha)

            condb = DriverManager.getConnection(url, user, senha);
            return condb;

        } catch (SQLException | ClassNotFoundException erro) {

            System.out.println("Erro ao conectar com o banco de dados" + erro);
            return null;
         }
    }
}

