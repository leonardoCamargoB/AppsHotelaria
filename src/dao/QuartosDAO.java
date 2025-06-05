package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
            novoQuarto.setInt(5, 150);
            novoQuarto.setBoolean(6, true);

            int linhaAfetada = novoQuarto.executeUpdate();
            return linhaAfetada > 0;
        }


        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
}

