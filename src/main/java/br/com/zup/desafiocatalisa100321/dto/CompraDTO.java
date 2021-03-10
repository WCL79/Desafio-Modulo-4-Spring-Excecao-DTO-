package br.com.zup.desafiocatalisa100321.dto;

import br.com.zup.desafiocatalisa100321.model.Cliente;
import br.com.zup.desafiocatalisa100321.model.Produto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CompraDTO {

    @NotBlank(message = "Campo do nome não pode estar vazio!")
    private Cliente cliente;
    @NotBlank(message = "Campo do nome não pode estar vazio!")
    private List<Produto> produtos;

    public CompraDTO() {
    }

    public CompraDTO(@NotBlank(message = "Campo do nome não pode estar vazio!") Cliente cliente,
                     @NotBlank(message = "Campo do nome não pode estar vazio!") List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
