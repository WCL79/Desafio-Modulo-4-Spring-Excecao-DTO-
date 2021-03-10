package br.com.zup.desafiocatalisa100321.dto;

import br.com.zup.desafiocatalisa100321.model.Cliente;
import br.com.zup.desafiocatalisa100321.model.Produto;

import javax.validation.constraints.NotBlank;


public class CompraDTO {

    @NotBlank(message = "Campo do nome não pode estar vazio!")
    private Cliente cliente;
    @NotBlank(message = "Campo do nome não pode estar vazio!")
    private Produto produtos;

    public CompraDTO() {
    }

    public CompraDTO(@NotBlank(message = "Campo do nome não pode estar vazio!")
                             Cliente cliente, @NotBlank(message = "Campo do nome não pode estar vazio!")
            Produto produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }
}
