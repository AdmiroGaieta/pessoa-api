package io.github.admirogaieta.pessoaapi.core.usecases;

import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;

public interface CreatePessoaUseCase {
   public Pessoa execute(Pessoa pessoa);
}
