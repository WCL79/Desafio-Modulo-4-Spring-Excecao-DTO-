package br.com.zup.desafiocatalisa100321.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class ProdutoDuplicadoExcecao extends RuntimeException{
    private int Status = 422;
    private String campo = "Nome do produto";
    private String razao = "Unprocessable Entity";
    private String tipoErro = "Produto encontrado!";

    public ProdutoDuplicadoExcecao(String message) {
        super(message);
    }

}
