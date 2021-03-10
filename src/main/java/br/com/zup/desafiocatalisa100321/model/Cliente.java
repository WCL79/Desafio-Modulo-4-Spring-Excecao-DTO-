package br.com.zup.desafiocatalisa100321.model;

import java.util.Objects;

/**
 * Classe modelo tipo Cliente com atributos com responsabilidades de validações
 * @author Weslley.candido
 * @version 0.01
 */
public class Cliente {
    private String nome;
    private String email;
    private String cpf;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(email, cliente.email) && Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
