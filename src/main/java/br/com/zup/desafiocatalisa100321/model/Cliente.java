package br.com.zup.desafiocatalisa100321.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Classe modelo tipo Cliente com atributos com responsabilidades de validações
 * @author Weslley.candido
 * @version 0.01
 */
@Data
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Cliente {
    @NotBlank(message = "Campo do nome não pode ser vazio!")
    @NotNull(message = "O campo do nome não foi informada")
    private String nome;

    @NotBlank(message = "Campo do e-mail não pode ser vazio!")
    @NotNull(message = "O campo e-mail não foi informada")
    @Email(message = "O e-mail informado é inválido!")
    private String email;

    @NotBlank(message = "Campo da raça não pode ser vazio!")
    @NotNull(message = "O campo raça não foi informada")
    private String cpf;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf) || Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, email);
    }
}
