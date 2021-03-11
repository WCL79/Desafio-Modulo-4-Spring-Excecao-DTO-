package br.com.zup.desafiocatalisa100321.dto;

import br.com.zup.desafiocatalisa100321.model.Cliente;
import br.com.zup.desafiocatalisa100321.model.Compra;
import br.com.zup.desafiocatalisa100321.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class CompraDTO {

    private String cpf;
    private List<ProdutoDTO> produtos;

    public Compra converterDTOCompra(Cliente cliente, List<Produto> produtos){
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProdutos(produtos);

        return compra;
    }

}
