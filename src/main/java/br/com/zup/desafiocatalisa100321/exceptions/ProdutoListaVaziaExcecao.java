package br.com.zup.desafiocatalisa100321.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class ProdutoListaVaziaExcecao extends RuntimeException{
    private int Status = 200;
    private String campo = "";
    private String razao = "Ok";
    private String tipoErro = "Lista de produtos vazia";

    public ProdutoListaVaziaExcecao(String message) {
        super(message);
    }
}
