package util;

import controller.UsuariosController;
import dao.*;
import model.Usuarios;

import java.sql.Connection;

public class TesteConexaoDB {
 public static void main(String[] args) {

     Conexao conexao = new Conexao();
     UsuariosController usuariosController = new UsuariosController();
     Connection condb = conexao.conectar();

     if (condb != null) {
         System.out.println("Conexão realizada com sucesso!");
         try {
             usuariosController.verificarCredenciais("kukishinobu92@gmail.com", "12345");
                condb.close();
          System.out.println("Conexão encerrada!");
         } catch (Exception erro) {
             System.out.println("Erro ao encerrar a conexão" + erro.getLocalizedMessage());
         }
     } else {
         System.out.println("Erro ao conectar com o banco de dados");
     }
 }
    
}
