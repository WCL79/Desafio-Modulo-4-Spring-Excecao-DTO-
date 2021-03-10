package br.com.zup.desafiocatalisa100321.service;
/**
 * Classe service tipo ClienteService com métodos responsaveis pela regra negocio
 * referente:
 * @author Weslley.candido
 * @version 0.01
 */
import br.com.zup.desafiocatalisa100321.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private static List<Cliente> clientes = new ArrayList<>();

    public Cliente cadastrarCliente(Cliente fregues) {
        clientes.add(fregues);
        return fregues;
    }

   /* public Cliente pesquisarCliente(String cpfDePesquisa)throws RuntimeException{
           Cliente cliente = new Cliente();
           cliente.setCpf(cpfDePesquisa);
           return pesquisarCliente(cliente);
    }*/

    public Cliente pesquisarCliente(String cpfDePesquisa){
        for(Cliente consumidor : clientes){
            if(consumidor.getCpf().equalsIgnoreCase(cpfDePesquisa)){
                return consumidor;
            }
        }
        throw new RuntimeException("O paciente com CPF " + cpfDePesquisa+ " Já existe cadastrado");
    }

}
