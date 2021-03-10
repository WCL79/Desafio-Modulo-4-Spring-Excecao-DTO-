package br.com.zup.desafiocatalisa100321.service;

import br.com.zup.desafiocatalisa100321.model.Cliente;
import br.com.zup.desafiocatalisa100321.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private static List<Produto> produtos = new ArrayList<>();

    public Produto cadastrarProduto(Produto mercadoria) {
        produtos.add(mercadoria);
        return mercadoria;
    }



}
