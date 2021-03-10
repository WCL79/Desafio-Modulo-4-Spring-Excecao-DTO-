package br.com.zup.desafiocatalisa100321.controller;
/**
 * Classe controller responsavel pela interação com a Classe Cliente da model ao services ClienteService
 * @author Weslley.candido
 * @version 0.01
 */
import br.com.zup.desafiocatalisa100321.model.Cliente;
import br.com.zup.desafiocatalisa100321.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestControllerAdvice
@RequestMapping("clientes/")
public class ClienteController {

    /**
     * Esse método fica responsavel com a injeção de dependencia, ou seja,
     * é um tipo de inversão (Inversion of Control – IoC)
     */
    @Autowired
    private ClienteService clienteServiceService;

    /**
     * Médoto que cria um Objeto do tipo Cliente
     * @param consumidor
     * @return Serviço do médoto cadastrarCliente que vem da Classe ClienteService.
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrarCliente(@RequestBody @Valid Cliente consumidor){
        return  clienteServiceService.cadastrarCliente(consumidor);
    }

    /**
     *Médoto que faz Vizualização do Objeto criado
     * @param cpf
     * @return: Serviço do médoto pesquisarCliente.
     */

    @GetMapping("{cpf}/")
    @ResponseStatus(HttpStatus.OK)
    public Cliente pesquisarPesquisarClientePorCpf(@PathVariable String cpf){
        return  clienteServiceService.pesquisarCpfDoCliente(cpf);
    }
}
