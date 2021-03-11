package br.com.zup.desafiocatalisa100321.exceptions;

import lombok.*;

@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
@Getter
@Setter
public class ProdutoReplicaExcecao extends Exception {
    private int Status = 400;
    private String campo = "Nome do produto";
    private String razao = "Bad Request";
    private String tipoErro = "Produto encontrado!";


    public ProdutoReplicaExcecao(String s) {
        super(s);
    }
}
