package io.github.admirogaieta.pessoaapi.infraestructure.persistence;

import io.github.admirogaieta.pessoaapi.core.enums.EnumTipoPessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor // Adicione esta anotação para criar um construtor padrão
@Data
@Table(name = "tb_Pessoa")
public class PessoaEntity {
    @Id 
    @GeneratedValue
    private long id;
    private String nome;
    private String email;
    private String bi;
    @Enumerated(EnumType.STRING)
    private EnumTipoPessoa tipoPessoa;

}
