package io.github.admirogaieta.pessoaapi.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.admirogaieta.pessoaapi.core.gateways.PessoaGateway;
import io.github.admirogaieta.pessoaapi.core.usecases.CreatePessoaUseCase;
import io.github.admirogaieta.pessoaapi.core.usecases.CreatePessoaUseCaseImpl;
import io.github.admirogaieta.pessoaapi.core.usecases.DeletePessoaUseCase;
import io.github.admirogaieta.pessoaapi.core.usecases.DeletePessoaUseCaseImpl;
import io.github.admirogaieta.pessoaapi.core.usecases.GetAllPessoaUseCaseImpl;
import io.github.admirogaieta.pessoaapi.core.usecases.GetAllPessoasUseCase;
import io.github.admirogaieta.pessoaapi.core.usecases.UpdatePessoaUseCase;
import io.github.admirogaieta.pessoaapi.core.usecases.UpdatePessoaUseCaseImpl;
import io.github.admirogaieta.pessoaapi.infraestructure.controllers.PessoaDtoMapper;

@Configuration
public class BeansConfig {

    @Bean
    public CreatePessoaUseCase  createPessoaUseCase(PessoaGateway pessoaGateway)
    {
       return new  CreatePessoaUseCaseImpl(pessoaGateway);
    }
    @Bean 
    public GetAllPessoasUseCase  getAllPessoasUseCase(PessoaGateway pessoaGateway, PessoaDtoMapper mapper){
        return new GetAllPessoaUseCaseImpl(pessoaGateway); }
    
        @Bean
        public UpdatePessoaUseCase updatePessoaUseCase(PessoaGateway pessoaGateway) {
            return new UpdatePessoaUseCaseImpl(pessoaGateway);
        }     
        @Bean
        public DeletePessoaUseCase deletePessoaUseCase(PessoaGateway pessoaGateway) {
            return new DeletePessoaUseCaseImpl(pessoaGateway);
        }

    @Bean // Adicione esta configuração para criar o bean PessoaDtoMapper
    public PessoaDtoMapper pessoaDtoMapper() {
        return new PessoaDtoMapper();
    }
}
