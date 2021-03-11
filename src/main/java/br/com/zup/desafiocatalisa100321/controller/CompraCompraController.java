package br.com.zup.desafiocatalisa100321.controller;

import br.com.zup.desafiocatalisa100321.dto.CompraDTO;
import br.com.zup.desafiocatalisa100321.model.Cliente;
import br.com.zup.desafiocatalisa100321.model.Compra;
import br.com.zup.desafiocatalisa100321.model.Produto;
import br.com.zup.desafiocatalisa100321.service.ClienteService;
import br.com.zup.desafiocatalisa100321.service.CompraService;
import br.com.zup.desafiocatalisa100321.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras/")
public class CompraCompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compra cadastrarCompra(@RequestBody CompraDTO compra) {
        Cliente cliente = clienteService.pesquisarCpfDoCliente(compra.getCpf());
        List<Produto> produtos = produtoService.pesquisarCompraDeProduto(compra.getProdutos());
        return compraService.cadastrarCompra(compra.converterDTOCompra(cliente, produtos));
    }
}
