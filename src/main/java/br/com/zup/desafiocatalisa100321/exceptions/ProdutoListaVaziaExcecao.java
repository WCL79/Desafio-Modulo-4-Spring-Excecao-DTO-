package br.com.zup.desafiocatalisa100321.exceptions;

import lombok.*;

@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
@Getter
@Setter
public class ProdutoListaVaziaExcecao extends Throwable {
    private int Status = 200;
    private String campo = "";
    private String razao = "Ok";
    private String tipoErro = "Lista de produtos vazia";

    public ProdutoListaVaziaExcecao (String s){
        super(s);
    }
}
