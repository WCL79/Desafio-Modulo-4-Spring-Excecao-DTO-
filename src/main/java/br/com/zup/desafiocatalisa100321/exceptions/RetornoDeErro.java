package br.com.zup.desafiocatalisa100321.exceptions;

import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
@Getter
@Setter
public class RetornoDeErro {
    private String tipoDeErro;
    private int codigoDoErro;
    private String statusCode;
    private List<ObjetoDeErro> objetoDeErro;
}
