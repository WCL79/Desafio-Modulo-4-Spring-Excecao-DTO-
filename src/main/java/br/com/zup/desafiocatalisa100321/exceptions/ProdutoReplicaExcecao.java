package br.com.zup.desafiocatalisa100321.exceptions;
 /*
    Classe para Exceção personalizada para:
    400 BAD REQUEST
    O servidor não pode ou não processará a solicitação
    devido a algo que é percebido como um erro do cliente
    (por exemplo, sintaxe de solicitação malformada, enquadramento de mensagem de solicitação inválido ou
     roteamento de solicitação enganoso).
     */
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
