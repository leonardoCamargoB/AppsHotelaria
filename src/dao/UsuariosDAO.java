package dao;

import model.Usuarios;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ServiceLoader;

public class UsuariosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();

            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios" +
                    "(nome, email, senha, cargo_id) VALUES (?,?,md5(?),?);");

            novoUsuario.setString(1, "Leonardo");
            novoUsuario.setString(2, "Leonardo@gmail.com");
            novoUsuario.setString(3, "Leonardo123");
            novoUsuario.setInt(4, 1);

            int linhaAfetada = novoUsuario.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }

    public boolean alterarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement usuarioAlterado = conndb.prepareStatement
                    ("UPDATE usuarios" + "SET nome = ?, email = ?, senha = md5(?) + ?, " +
                            "fk_regras = ? WHERE id = ?; ");
            usuarioAlterado.setString(1, "");
            usuarioAlterado.setString(2, "");
            usuarioAlterado.setString(3, "");
            usuarioAlterado.setInt(4, 1);
            usuarioAlterado.setInt(5, 1);
            int linhaAfetada = usuarioAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar usuario: " + erro);
            return false;
        }
    }


    public boolean deletarUsuarios() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removerUsuarios = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?;");

            removerUsuarios.setInt(1, 1);

            int LinhaAfetada = removerUsuarios.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuarios: " + erro);
            return false;
        }

    }
}
