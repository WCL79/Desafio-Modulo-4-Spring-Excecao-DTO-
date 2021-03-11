package br.com.zup.desafiocatalisa100321.service;

import br.com.zup.desafiocatalisa100321.dto.ProdutoDTO;
import br.com.zup.desafiocatalisa100321.exceptions.ProdutoDuplicadoExcecao;
import br.com.zup.desafiocatalisa100321.model.Produto;
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

    public Produto cadastrarProduto(Produto mercadoria) {
        if (!produtos.contains(mercadoria)) {
            produtos.add(mercadoria);
            return mercadoria;
        } else {
            throw new ProdutoDuplicadoExcecao("Produto com "+mercadoria.getNome()+"já cadastrado!");
        }
    }

    public List<Produto> pesquisarProduto() {
        if (produtos.size() > 0) {
            return produtos;
        }
        throw new ProdutoDuplicadoExcecao("Não existe produto cadastrado!");
    }

    public  List<Produto> pesquisarCompraDeProduto(List<ProdutoDTO> produtoDTOS){
        List<Produto> produtosDeCompras = new ArrayList<>();
        for(ProdutoDTO produtoDTO : produtoDTOS){//Essa é responsável dos nomes dos produtos que o cliente passou
           for(Produto produto : produtos){
               if(produto.getNome().equalsIgnoreCase(produtoDTO.getNome())){
                   produtosDeCompras.add(produto);
               }
           }
        }
        return produtosDeCompras;
    }
}
