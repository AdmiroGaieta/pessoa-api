package io.github.admirogaieta.pessoaapi.core.gateways;

import java.util.List;
import java.util.Optional;

import io.github.admirogaieta.pessoaapi.core.entities.Pessoa;

public interface PessoaGateway {
  Pessoa createPessoa (Pessoa  pessoa);

 Pessoa findByBi(String bi);

  List<Pessoa> obtainAllPessoas();

  void deletePessoaById(long id);
 
  Optional<Pessoa> findById(long id); // Adicione este método à interface
  
  Optional<Pessoa> updatePessoa(Pessoa pessoa);

 

}
