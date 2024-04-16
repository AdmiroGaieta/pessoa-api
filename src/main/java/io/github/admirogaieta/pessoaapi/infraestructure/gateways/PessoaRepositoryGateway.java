package io.github.admirogaieta.pessoaapi.infraestructure.gateways;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;
import io.github.admirogaieta.pessoaapi.core.gateways.PessoaGateway;
import io.github.admirogaieta.pessoaapi.infraestructure.persistence.PessoaEntity;
import io.github.admirogaieta.pessoaapi.infraestructure.persistence.PessoaRepository;


@RequiredArgsConstructor
@Component
public class PessoaRepositoryGateway  implements PessoaGateway{
    private final PessoaRepository pessoaRepository;
    private final PessoaEntityMapper entityMapper;
    
    @Override
    public Pessoa createPessoa(Pessoa pessoa)
    {
        PessoaEntity entity=  entityMapper.toEntity(pessoa);
       PessoaEntity novaPessoa= pessoaRepository.save(entity);
       return entityMapper.toPessoa(novaPessoa);
    }

    @Override
    public Pessoa findByBi(String bi) {
     PessoaEntity entity =   pessoaRepository.findByBi(bi);
     if(entity==null)
     {
        return null;
     }
     return entityMapper.toPessoa(entity);
    }

    @Override
    public List<Pessoa> obtainAllPessoas() {
        // TODO Auto-generated method stub
        return pessoaRepository
        .findAll()
        .stream()
        .map(entityMapper::toPessoa)
        .collect(Collectors.toList());
        
    }
    @Override
    public void deletePessoaById(long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public Optional<Pessoa> findById(long id) {
        return pessoaRepository.findById(id)
                .map(entityMapper::toPessoa);
    }
    @Override
    public Optional<Pessoa> updatePessoa(Pessoa pessoa) {
        Optional<Pessoa> optionalPessoa = Optional.ofNullable(pessoa);
        if (optionalPessoa.isPresent()) {
            PessoaEntity entity = entityMapper.toEntity(pessoa);
            PessoaEntity updatedEntity = pessoaRepository.save(entity);
            return Optional.of(entityMapper.toPessoa(updatedEntity));
        } else {
            return Optional.empty(); // Retorna Optional.empty() se a pessoa for nula
        }
    }
}
