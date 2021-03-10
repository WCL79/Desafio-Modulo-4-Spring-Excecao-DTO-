package br.com.zup.desafiocatalisa100321.service;

import br.com.zup.desafiocatalisa100321.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static List<Produto> produtos = new ArrayList<>();

    public Produto cadastrarProduto(Produto mercadoria) {
        produtos.add(mercadoria);
        return mercadoria;
    }

    public List<Produto> pesquisarProduto() {
        return produtos;
        }
    }
