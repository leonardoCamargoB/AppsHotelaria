package util;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    private String driver;
    private String url;
    private String user;
    private String senha;

    public  Conexao() {
        carregarConfiguracoes();
    }

    private void carregarConfiguracoes() {
        Properties props = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream
                ("config.properties")){
          props.load(inputPropsConfig);
          driver = props.getProperty("driver");
          url = props.getProperty("url");
          user = props.getProperty("user");
          senha = props.getProperty("senha");
        }
        catch (IOException erro) {

            System.out.println("Erro ao carregar configurações" + erro.getMessage());
        }
    }
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

