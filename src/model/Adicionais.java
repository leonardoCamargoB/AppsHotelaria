package model;

public class Adicionais {
    int idAdicionais;
    String nome;
    double preco;

    public Adicionais( String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public int getIdAdicionais() {
        return idAdicionais;
    }
    public void setIdAdicionais(int idAdicionais) {
        this.idAdicionais = idAdicionais;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

}
