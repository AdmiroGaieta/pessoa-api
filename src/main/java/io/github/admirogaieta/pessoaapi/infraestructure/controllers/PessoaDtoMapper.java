package io.github.admirogaieta.pessoaapi.infraestructure.controllers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;
import io.github.admirogaieta.pessoaapi.infraestructure.dtos.PessoaDto;

@Component
public class PessoaDtoMapper {

    public PessoaDto toDto(Pessoa pessoa) {
        return new PessoaDto(pessoa.getNome(), pessoa.getEmail(), pessoa.getBi(), pessoa.getTipoPessoa());
    }

    public Pessoa toDomain(PessoaDto pessoaDto) {
        return new Pessoa(null, pessoaDto.nome(), pessoaDto.email(), pessoaDto.bi(), pessoaDto.tipoPessoa());
    }
}
