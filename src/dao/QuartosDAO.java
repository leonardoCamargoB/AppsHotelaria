package dao;

import util.Conexao;

import java.sql.*;

import model.Usuarios;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos(/*Usuarios usuario*/) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos" +
                    "(nome,numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES (?,?,?,?, ?, ?);");

            novoQuarto.setString(1, "Quarto casal");
            novoQuarto.setInt(2,31);
            novoQuarto.setInt(3,1 );
            novoQuarto.setInt(4,0);
            novoQuarto.setDouble(5, 150);
            novoQuarto.setBoolean(6, true);

            int linhaAfetada = novoQuarto.executeUpdate();
            return linhaAfetada > 0;
        }


        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }

    public boolean alterarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement quartoAlterado = conndb.prepareStatement
                    ("UPDATE quartos SET  nome = ?, numero = ?, qtd_cama_casal = ?, qtd_cama_solteiro = ?, preco = ?, disponivel = ? " +
                            "WHERE id = ?; ");
            quartoAlterado.setString(1, "quarto ao luar");
            quartoAlterado.setInt(2, 154);
            quartoAlterado.setInt(3, 2);
            quartoAlterado.setInt(4, 1);
            quartoAlterado.setDouble(5, 399);
            quartoAlterado.setBoolean(6, false);
            quartoAlterado.setInt(7, 1);

            int linhaAfetada = quartoAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar quarto: " + erro);
            return false;
        }
    }
    public void pesquisarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaQuartos = conndb.prepareStatement("SELECT nome, numero" +
                    "FROM quartos WHERE id = ?");
            buscaQuartos.setInt(1,1);
            ResultSet resultado = buscaQuartos.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String numero = resultado.getString("numero");
                System.out.println("Nome: " + nome + " - numero" + numero);
            } conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
        }
    }
    public boolean deletarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removerQuarto = conndb.prepareStatement ("DELETE FROM quartos WHERE id = ?;");

            removerQuarto.setInt(1,1);

            int LinhaAfetada = removerQuarto.executeUpdate();
            return LinhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar quarto: " + erro);
            return false;
        }

    }
}

