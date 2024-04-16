package io.github.admirogaieta.pessoaapi.core.usecases;

import io.github.admirogaieta.pessoaapi.core.gateways.PessoaGateway;

public class DeletePessoaUseCaseImpl implements DeletePessoaUseCase {

    private final PessoaGateway pessoaGateway;

    public DeletePessoaUseCaseImpl(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public void deletePessoa(long id) {
        // Implemente a lógica para excluir uma pessoa pelo ID
        pessoaGateway.deletePessoaById(id);
    }
}
