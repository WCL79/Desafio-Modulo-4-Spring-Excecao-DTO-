package br.com.zup.desafiocatalisa100321.dto;

import java.util.List;


public class CompraDTO {

    private String cpf;
    private List<ProdutoDTO> produtos;

    public CompraDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
