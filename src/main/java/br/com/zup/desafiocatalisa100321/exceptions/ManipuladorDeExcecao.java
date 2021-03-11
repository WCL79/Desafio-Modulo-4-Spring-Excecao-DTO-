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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ManipuladorDeExcecao extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request){
        List<ObjetoDeErro> objetoDeErroList = pergarErros(ex);
        return ResponseEntity.status(400).body(objetoDeErroList);

    }
    /**
     * Responsavel pela montagem dos OBJETOS de erros.
     * @param exception
     * @return: a lista de Objetos de erros
     */
    private List<ObjetoDeErro> pergarErros (MethodArgumentNotValidException exception){
        //getFieldErrors() devolve lista de Campos com erros na validação,como sendo List,
        //pode-se usar o recurso Stream ao aplicar for
        List<ObjetoDeErro> objetoDeErroList = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> new ObjetoDeErro(erro.getDefaultMessage(),
                        erro.getField())).collect(Collectors.toList());
        return  objetoDeErroList;
    }
}