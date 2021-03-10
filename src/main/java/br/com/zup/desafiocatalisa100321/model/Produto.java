package br.com.zup.desafiocatalisa100321.model;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * Classe modelo tipo Produto com atributos com responsabilidades de validações
 * @author Weslley.candido
 * @version 0.01
 */

public class Produto {
    @NotBlank(message = "Campo do nome não pode estar vazio!")
    private String nome;

    @NotBlank(message = "Campo do nome não pode estar vazio!")
    private double preco;

    @NotBlank(message = "Campo do nome não pode estar vazio!")
    private int quantidade;

    public Produto() {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
