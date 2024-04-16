package io.github.admirogaieta.pessoaapi.core.usecases;

import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;

public interface UpdatePessoaUseCase {
    Pessoa execute(long id, Pessoa updatedPessoa);
}
