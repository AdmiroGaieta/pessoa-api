package io.github.admirogaieta.pessoaapi.infraestructure.dtos;

import io.github.admirogaieta.pessoaapi.core.enums.EnumTipoPessoa;

public record PessoaDto(String nome, String email, String bi, EnumTipoPessoa tipoPessoa) {
  
}
 