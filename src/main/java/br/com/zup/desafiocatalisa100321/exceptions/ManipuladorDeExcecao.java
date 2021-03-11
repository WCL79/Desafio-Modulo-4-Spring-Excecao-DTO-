package br.com.zup.desafiocatalisa100321.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ManipuladorDeExcecao extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request){
        RespostaDeErro respostaDeErro= new RespostaDeErro(
                "Validação de dados",
                status.value(),
                status.getReasonPhrase(),
                pergarErros(exception)
        );
        return ResponseEntity.status(status).body(respostaDeErro);
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private List<ObjetoDeErro> pergarErros (MethodArgumentNotValidException exception){
        //Esse médoto foi objeto de estudo 09/03/21
        //getFieldErrors() devolve lista de Campos com erros na validação,como sendo List,
        //pode-se usar o recurso Stream ao invés de aplicar for
        List<ObjetoDeErro> objetoDeErroList = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> new ObjetoDeErro(erro.getDefaultMessage(),
                        erro.getField())).collect(Collectors.toList());
        return  objetoDeErroList;
    }

    @ExceptionHandler({ProdutoDuplicadoExcecao.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErro produtoDuplicadoExcecao(ProdutoDuplicadoExcecao excecao) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                excecao.getMessage(),
                excecao.getCampo()
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(excecao.getTipoErro(),
                excecao.getStatus(), excecao.getRazao(), Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }

    @ExceptionHandler({ProdutoListaVaziaExcecao.class})
    @ResponseStatus(HttpStatus.OK)
    public RespostaDeErro produtoListaVaziaExcecao(ProdutoListaVaziaExcecao excecao) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                excecao.getMessage(),
                excecao.getCampo()
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(excecao.getTipoErro(),
                excecao.getStatus(), excecao.getRazao(), Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }

    @ExceptionHandler({ClienteDuplicadoExcecao.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErro clienteDuplicadoExcecao(ClienteDuplicadoExcecao ex) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                ex.getMessage(),
                ex.getCampo()
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(ex.getTipoErro(),
                ex.getStatus(),
                ex.getRazao(),
                Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }

}
