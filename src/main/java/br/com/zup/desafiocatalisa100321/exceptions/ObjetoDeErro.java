package br.com.zup.desafiocatalisa100321.exceptions;

import lombok.*;

/**
 * @author Weslley.candido
 * @version 0.01
 * Classe responsavel pela criação de objetos de ERROS
 * As mensagem serão encaminhadas ao usuário no formato JSON
 */
@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
@Getter
@Setter
public class ObjetoDeErro {
    private String notificacao;
    private String campo;

}