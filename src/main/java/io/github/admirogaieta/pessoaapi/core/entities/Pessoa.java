package io.github.admirogaieta.pessoaapi.core.entities;

import io.github.admirogaieta.pessoaapi.core.enums.EnumTipoPessoa;

public class Pessoa {
    private Long id;
    private String nome;
    private String email;
    private String bi;
    private EnumTipoPessoa tipoPessoa;

    public Pessoa(Long id, String nome, String email, String bi, EnumTipoPessoa tipoPessoa) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.bi = bi;
        this.tipoPessoa = tipoPessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public EnumTipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
