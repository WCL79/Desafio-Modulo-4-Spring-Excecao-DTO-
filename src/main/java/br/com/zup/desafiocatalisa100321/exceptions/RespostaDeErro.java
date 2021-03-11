package br.com.zup.desafiocatalisa100321.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class RespostaDeErro {
    private String tipoDeErro;
    private int codigo;
    private String status;
    private List<ObjetoDeErro> objetosDeErro;
}
