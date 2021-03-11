package br.com.zup.desafiocatalisa100321.model;
/**
 * Classe modelo tipo Compra com atributos do tipo Cliente e List<Produto>
 * @author Weslley.candido
 * @version 0.01
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class Compra {
    private Cliente cliente;
    private List<Produto> produtos;


}
