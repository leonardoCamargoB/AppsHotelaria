package util;

import dao.*;

import java.sql.Connection;

public class TesteConexaoDB {
 public static void main(String[] args) {

     Conexao conexao = new Conexao();
     Connection condb = conexao.conectar();

     if (condb != null) {
         System.out.println("Conexão realizada com sucesso!");

         try {
            QuartosDAO quartosDAO = new QuartosDAO();
             quartosDAO.inserirQuartos();
             System.out.println("Quarto inserido com sucesso!");

             System.out.println("Conexão encerrada!");
         } catch (Exception erro) {
             System.out.println("Erro ao encerrar a conexão" + erro.getLocalizedMessage());
         }
     } else {
         System.out.println("Erro ao conectar com o banco de dados");
     }
 }
    
}
