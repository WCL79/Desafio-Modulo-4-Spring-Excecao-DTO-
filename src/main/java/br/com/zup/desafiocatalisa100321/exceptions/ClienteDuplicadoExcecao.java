package br.com.zup.desafiocatalisa100321.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class ClienteDuplicadoExcecao extends RuntimeException{
    private int Status = 422;
    private String campo = "Nome do produto ou e-mail";
    private String razao = "Unprocessable Entity";
    private String tipoErro = "Cliente duplicado!";

    public ClienteDuplicadoExcecao(String message) {
        super(message);
    }
}
