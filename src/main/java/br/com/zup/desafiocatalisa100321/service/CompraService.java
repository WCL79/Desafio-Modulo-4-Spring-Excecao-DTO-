package br.com.zup.desafiocatalisa100321.service;

import br.com.zup.desafiocatalisa100321.model.Compra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    private List<Compra> compras = new ArrayList<>();

    public Compra cadastrarCompra(Compra compra) {
        compras.add(compra);
        return compra;
    }

    public List<Compra> compraList() {
        if (this.compras.size() > 0) {
            return this.compras;
        }
        throw new RuntimeException ("Não existe compras cadastradas!");
    }
}
