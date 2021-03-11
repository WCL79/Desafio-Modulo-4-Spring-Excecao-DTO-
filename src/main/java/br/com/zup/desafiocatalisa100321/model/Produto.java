package br.com.zup.desafiocatalisa100321.model;

import lombok.*;

import java.util.Objects;

/**
 * Classe modelo tipo Produto com atributos com responsabilidades de validações
 * @author Weslley.candido
 * @version 0.01
 */
@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class Produto {

    private String nome;
    private double preco;
    private int quantidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

}
