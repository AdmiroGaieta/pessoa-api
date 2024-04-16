package io.github.admirogaieta.pessoaapi.core.usecases;

import java.util.Optional;
import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;
import io.github.admirogaieta.pessoaapi.core.gateways.PessoaGateway;

public class UpdatePessoaUseCaseImpl implements UpdatePessoaUseCase {

    private final PessoaGateway pessoaGateway;

    public UpdatePessoaUseCaseImpl(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public Pessoa execute(long id, Pessoa updatedPessoa) {
        Optional<Pessoa> existingPessoa = pessoaGateway.findById(id);
        if (existingPessoa.isPresent()) {
            Pessoa pessoa = existingPessoa.get();
            pessoa.setNome(updatedPessoa.getNome());
            pessoa.setEmail(updatedPessoa.getEmail());
            pessoa.setBi(updatedPessoa.getBi());
            pessoa.setTipoPessoa(updatedPessoa.getTipoPessoa());
            // Outros campos que você deseja atualizar
            
            // Salva a pessoa atualizada no gateway
            pessoaGateway.updatePessoa(pessoa);
            
            // Retorna a pessoa atualizada
            return pessoa;
        } else {
            throw new IllegalArgumentException("Pessoa não encontrada com o ID fornecido: " + id);
        }
    }

}
