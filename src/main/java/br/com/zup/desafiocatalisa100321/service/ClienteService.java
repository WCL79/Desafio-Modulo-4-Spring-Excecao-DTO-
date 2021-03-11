package br.com.zup.desafiocatalisa100321.service;
/**
 * Classe service tipo ClienteService com métodos responsaveis pela regra negocio
 * referente:
 * @author Weslley.candido
 * @version 0.01
 */
import br.com.zup.desafiocatalisa100321.exceptions.ClienteDuplicadoExcecao;
import br.com.zup.desafiocatalisa100321.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private static List<Cliente> clientes = new ArrayList<>();

    public Cliente cadastrarCliente(Cliente fregues) {
        if(!clientes.contains(fregues)) {
            clientes.add(fregues);
            return fregues;
        }
        throw new ClienteDuplicadoExcecao("O CPF" + fregues.getCpf() + " ou e-mail " + fregues.getEmail() +
                " cliente EXISTENTE!");
    }

    public Cliente pesquisarCpfDoCliente(String cpf) {
        for(Cliente consumidor : clientes) {
            if (consumidor.getCpf().equalsIgnoreCase(cpf)) {
                return consumidor;
            }
        }
        throw new ClienteDuplicadoExcecao("Nenhum cliente foi encontrado com CPF: " + cpf);
    }
}
