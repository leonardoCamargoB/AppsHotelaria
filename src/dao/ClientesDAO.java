package dao;

import util.Conexao;

import java.sql.*;

import model.Usuarios;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

    public class ClientesDAO {
        private Conexao conexao = new Conexao();

        public boolean inserirCliente(/*Usuarios usuario*/) {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes" +
                        "(nome,cpf, telefone, email) VALUES (?,?,?,?);");

                novoCliente.setString(1, "Leonardo");
                novoCliente.setString(2, "123-456-678-99");
                novoCliente.setString(3, "15-98818-8424");
                novoCliente.setString(4,"leonardo@gmail.com");

                int linhaAfetada = novoCliente.executeUpdate();
                return linhaAfetada > 0;
            }


            catch (Exception erro) {
                System.out.println("Erro ao inserir usuario: " + erro);
                return false;
            }
        }

        public boolean alterarCliente() {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement clienteAlterado = conndb.prepareStatement
                        ("UPDATE clientes" + "SET nome = ?, cpf = ?, telefone = ?, email = ? + ?, " +
                                "fk_regras = ? WHERE id = ?; ");
                clienteAlterado.setString(1, "");
                clienteAlterado.setString(2, "");
                clienteAlterado.setString(3, "");
                clienteAlterado.setInt(4, 1);
                clienteAlterado.setInt(5, 1);
                int linhaAfetada = clienteAlterado.executeUpdate();
                conndb.close();
                return linhaAfetada > 0;
            } catch (Exception erro) {
                System.out.println("Erro ao alterar cliente: " + erro);
                return false;
            }


        }
        public void pesquisarCliente() {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement buscaCliente = conndb.prepareStatement("SELECT nome, email" +
                        "FROM clientes WHERE id = ?");
                buscaCliente.setInt(1,1);
                ResultSet resultado = buscaCliente.executeQuery();

                while (resultado.next()) {
                    String nome = resultado.getString("nome");
                    String email = resultado.getString("email");
                    System.out.println("Nome: " + nome + " - Email" + email);
                } conndb.close();
            }
            catch (Exception erro) {
                System.out.println("Erro ao pesquisar cliente: " + erro);
            }
        }
        public boolean deletarClientes() {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement removerCliente = conndb.prepareStatement ("DELETE FROM clientes WHERE id = ?;");

                removerCliente.setInt(1,1);

                int LinhaAfetada = removerCliente.executeUpdate();
                return LinhaAfetada > 0;
            }
            catch (Exception erro) {
                System.out.println("Erro ao deletar cliente: " + erro);
                return false;
            }

        }
    }

