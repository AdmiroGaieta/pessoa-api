package io.github.admirogaieta.pessoaapi.core.usecases;

import java.util.List; // Importe o java.util.List corretamente

import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;
import io.github.admirogaieta.pessoaapi.core.gateways.PessoaGateway;

public class GetAllPessoaUseCaseImpl implements GetAllPessoasUseCase {
    private final PessoaGateway pessoaGateway;

    public GetAllPessoaUseCaseImpl(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public List<Pessoa> execute() {
        return pessoaGateway.obtainAllPessoas();
    }
}
