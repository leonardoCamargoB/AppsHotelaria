package dao;

import util.Conexao;

import java.sql.*;

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


    public boolean alterarAdicionalo() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement adicionalAlterado = conndb.prepareStatement
                    ("UPDATE adicionais" + "SET nome = ?, preco = ? + ?, " +
                            "fk_regras = ? WHERE id = ?; ");
            adicionalAlterado.setString(1, "");
            adicionalAlterado.setInt(2, 150);
            int linhaAfetada = adicionalAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar adicional: " + erro);
            return false;
        }
    }
    public void pesquisarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaAdicionais = conndb.prepareStatement("SELECT nome, preço" +
                    "FROM adicionais WHERE id = ?");
            buscaAdicionais.setInt(1,1);
            ResultSet resultado = buscaAdicionais.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String preco = resultado.getString("preço");
                System.out.println("Nome: " + nome + " - preço" + preco);
            } conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
        }
    }

    public boolean deletarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removerAdicional = conndb.prepareStatement ("DELETE FROM adicionais WHERE id = ?;");

            removerAdicional.setInt(1,1);

            int LinhaAfetada = removerAdicional.executeUpdate();
            return LinhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar adicional: " + erro);
            return false;
        }

    }
}

