package br.com.zup.desafiocatalisa100321.model;
/**
 * Classe modelo tipo Compra com atributos do tipo Cliente e List<Produto>
 * @author Weslley.candido
 * @version 0.01
 */
import java.util.List;

public class Compra {
    private Cliente cliente;
    private List<Produto> produtos;

    public Compra() {
    }

    public Compra(Cliente cliente, List<Produto> produtos) {
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
