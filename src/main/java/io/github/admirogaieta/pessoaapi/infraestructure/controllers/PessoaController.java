package io.github.admirogaieta.pessoaapi.infraestructure.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;
import io.github.admirogaieta.pessoaapi.core.usecases.CreatePessoaUseCase;
import io.github.admirogaieta.pessoaapi.core.usecases.DeletePessoaUseCase;
import io.github.admirogaieta.pessoaapi.core.usecases.GetAllPessoasUseCase;
import io.github.admirogaieta.pessoaapi.core.usecases.UpdatePessoaUseCase;
import io.github.admirogaieta.pessoaapi.infraestructure.dtos.PessoaDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/pessoas")
@AllArgsConstructor
public class PessoaController {
    private final CreatePessoaUseCase createPessoaUseCase;
    private final GetAllPessoasUseCase getAllPessoasUseCase;
    private final PessoaDtoMapper pessoaDtoMapper;
    private final DeletePessoaUseCase deletePessoaUseCase;
    private final UpdatePessoaUseCase updatePessoaUseCase;

    @PostMapping
    public PessoaDto createPessoa(@RequestBody PessoaDto pessoaDto) {
        Pessoa novaPessoa = createPessoaUseCase.execute(pessoaDtoMapper.toDomain(pessoaDto));
        return pessoaDtoMapper.toDto(novaPessoa);
    }

    @GetMapping
    public List<PessoaDto> obtainAllPessoas() {
        return getAllPessoasUseCase.execute()
                .stream()
                .map(pessoaDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePessoa(@PathVariable long id) {
        deletePessoaUseCase.deletePessoa(id);
        return ResponseEntity.ok("Pessoa eliminada com sucesso.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> updatePessoa(@PathVariable long id, @RequestBody PessoaDto pessoaDto) {
        Pessoa updatedPessoa = pessoaDtoMapper.toDomain(pessoaDto);
        Pessoa pessoaAtualizada = updatePessoaUseCase.execute(id, updatedPessoa);
        return ResponseEntity.ok(pessoaDtoMapper.toDto(pessoaAtualizada));
    }
    
}
