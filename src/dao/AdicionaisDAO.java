package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Usuarios;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais(/*Usuarios usuario*/) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicional = conndb.prepareStatement("INSERT INTO adicionais" +
                    "(nome, preco) VALUES (?,?);");

            novoAdicional.setString(1, "Serviço de Quarto");
            novoAdicional.setInt(2,45);


            int linhaAfetada = novoAdicional.executeUpdate();
            return linhaAfetada > 0;
        }



        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
}

