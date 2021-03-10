package br.com.zup.desafiocatalisa100321.controller;

import br.com.zup.desafiocatalisa100321.model.Produto;
import br.com.zup.desafiocatalisa100321.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestControllerAdvice
@RequestMapping("produtos/")
public class ProdutoControlller {

    @Autowired
    private ProdutoService produtoService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrarProduto (@RequestBody @Valid Produto produto){
        return produtoService.cadastrarProduto(produto);
    }
}
