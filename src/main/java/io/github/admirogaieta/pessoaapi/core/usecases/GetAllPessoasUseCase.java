package io.github.admirogaieta.pessoaapi.core.usecases;

import java.util.List;

import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;

public interface GetAllPessoasUseCase {
    public List<Pessoa> execute();

}
