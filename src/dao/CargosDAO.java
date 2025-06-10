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

    public boolean alterarCargo() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement cargoAlterado = conndb.prepareStatement
                    ("UPDATE cargos" + "SET nome = ? + ?, " +
                            "fk_regras = ? WHERE id = ?; ");
            cargoAlterado.setString(1, "");
            int linhaAfetada = cargoAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar cargo: " + erro);
            return false;
        }
    }
    public boolean deletarCargos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removerCargo = conndb.prepareStatement ("DELETE FROM cargos WHERE id = ?;");

            removerCargo.setInt(1,1);

            int LinhaAfetada = removerCargo.executeUpdate();
            return LinhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar cargo: " + erro);
            return false;
        }

    }
}

