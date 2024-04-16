package io.github.admirogaieta.pessoaapi.infraestructure.gateways;

import org.springframework.stereotype.Component;

import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;
import io.github.admirogaieta.pessoaapi.infraestructure.persistence.PessoaEntity;

@Component // Adicione a anotação @Component
public class PessoaEntityMapper {
   
    public PessoaEntity toEntity(Pessoa pessoa)
    {
        return  new PessoaEntity(0,pessoa.getNome(),pessoa.getEmail(),pessoa.getBi(),pessoa.getTipoPessoa());
               
    }
    public Pessoa toPessoa(PessoaEntity entity){
        
        return new Pessoa(entity.getId(),entity.getNome(),entity.getEmail(),entity.getBi(),entity.getTipoPessoa());
    }
}
