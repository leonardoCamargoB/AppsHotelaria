package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CargosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCargo(/*Usuarios usuario*/) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCargo = conndb.prepareStatement("INSERT INTO Cargos" +
                    "(nome) VALUES (?);");

            novoCargo.setString(1, "Jardineiro");


            int linhaAfetada = novoCargo.executeUpdate();
            return linhaAfetada > 0;
        }


        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
}

