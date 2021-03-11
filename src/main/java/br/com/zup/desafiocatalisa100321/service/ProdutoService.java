package br.com.zup.desafiocatalisa100321.service;

import br.com.zup.desafiocatalisa100321.exceptions.ProdutoListaVaziaExcecao;
import br.com.zup.desafiocatalisa100321.exceptions.ProdutoReplicaExcecao;
import br.com.zup.desafiocatalisa100321.model.Produto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static List<Produto> produtos = new ArrayList<>();

    /**
     * Método responsavel pela inserção de novo produto, porém somente é possível mediante produto único
     * por nome.
     * @param mercadoria
     * @return
     */
    @SneakyThrows
    public Produto cadastrarProduto(Produto mercadoria) {
        if (!produtos.contains(mercadoria)) {
            produtos.add(mercadoria);
            return mercadoria;
        } else {
            throw new ProdutoReplicaExcecao("Produto com "+mercadoria.getNome()+"já cadastrado!");
        }
    }
    @SneakyThrows
    public List<Produto> pesquisarProduto() {
        if (produtos.size() > 0) {
            return produtos;
        }
        throw new ProdutoListaVaziaExcecao("Não existe produto cadastrado!");
        }
    }
