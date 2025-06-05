package dao;

import model.Usuarios;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario(/*Usuarios usuario*/) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios" +
                    "(nome, email, senha, cargo_id) VALUES (?,?,md5(?),?);");

            novoUsuario.setString(1, "Leonardo");
            novoUsuario.setString(2, "Leonardo@gmail.com");
            novoUsuario.setString(3, "Leonardo123");
            novoUsuario.setInt(4,1);

            int linhaAfetada = novoUsuario.executeUpdate();
            return linhaAfetada > 0;
        }


        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
}
