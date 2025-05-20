package model;

public class Usuarios extends Pessoa {
   private int id, role_id;
    private String senha;


    public Usuarios(String nome, String email,  String senha, int id) {
        super(nome, email);
        this.senha = senha;
        this.id = id;
    }
    public int getId() {
        return id;
    }
     public void setId(int id) {
        this.id = id;
     }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}