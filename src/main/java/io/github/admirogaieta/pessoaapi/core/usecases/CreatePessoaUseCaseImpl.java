package io.github.admirogaieta.pessoaapi.core.usecases;
import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;
import io.github.admirogaieta.pessoaapi.core.exceptions.BusinessException;
import io.github.admirogaieta.pessoaapi.core.gateways.PessoaGateway;
 
public class CreatePessoaUseCaseImpl implements CreatePessoaUseCase{

    private final PessoaGateway  pessoaGateway;

    public CreatePessoaUseCaseImpl(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public Pessoa execute(Pessoa pessoa) {
       Pessoa pessoaExistente=  pessoaGateway.findByBi(pessoa.getBi());
         if(pessoaExistente !=null)
         {
            throw new BusinessException("Já existe alguém com o BI" + pessoa.getBi());
         }
         return pessoaGateway.createPessoa(pessoa);
    }
   
}
