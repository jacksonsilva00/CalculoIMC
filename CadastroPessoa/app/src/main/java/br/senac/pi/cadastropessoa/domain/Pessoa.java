package br.senac.pi.cadastropessoa.domain;

/**
 * Created by Aluno on 25/11/2015.
 */
public class Pessoa {
    private long id;
    private String cpf;
    private String nome;
    private int telefone;

    public Pessoa(){}
    public Pessoa(String cpf , String nome, int telefone , long id){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
