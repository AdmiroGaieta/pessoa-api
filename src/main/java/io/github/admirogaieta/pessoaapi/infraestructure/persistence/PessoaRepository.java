package io.github.admirogaieta.pessoaapi.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository  extends JpaRepository<PessoaEntity,Long>{

    PessoaEntity findByBi(String bi);

   
}
