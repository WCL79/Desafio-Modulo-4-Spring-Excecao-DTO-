package br.com.zup.desafiocatalisa100321.exceptions;

/**
 * @author Weslley.candido
 * @version 0.01
 * Classe responsavel pela manipulação dos objetos com ERROS
 * ResponseEntityExceptionHandler é classe que ficará responsavel em responder aos usuários
 */
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ManipuladorDeExcecao extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        RetornoDeErro retornoDeErro = new RetornoDeErro
                ("Validação de dados",
                        status.value(),
                        status.getReasonPhrase(),
                        pergarErros(ex));
        return ResponseEntity.status(status).body(retornoDeErro);

    }

    /**
     * Esse método irá capturar qualquer exceção desse sistema que for do tipo RuntimeException
     * Responsavel pela montagem dos OBJETOS de erros.
     *
     * @param exception
     * @return: a lista de Objetos de erros
     */

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private List<ObjetoDeErro> pergarErros(MethodArgumentNotValidException exception) {

        //Assunto estudado na data:09/03/2021 revisada em vídeo: 2h25
        //getFieldErrors() devolve lista de Campos com erros na validação,como sendo List,
        //pode-se usar o recurso Stream ao aplicar for

        List<ObjetoDeErro> objetoDeErroList = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> new ObjetoDeErro(erro.getDefaultMessage(),
                                 erro.getField())).collect(Collectors.toList());
        return objetoDeErroList;
    }

    @ExceptionHandler({ProdutoReplicaExcecao.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RetornoDeErro produtoReplicadoExcecao(ProdutoReplicaExcecao excecao) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                excecao.getMessage(),
                excecao.getCampo());
        RetornoDeErro retornoDeErro = new RetornoDeErro(excecao.getTipoErro(),
                                                        excecao.getStatus(),
                                                        excecao.getRazao(),
                                                        Arrays.asList(objetoDeErro));
        return retornoDeErro;
    }


}