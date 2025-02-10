package com.tjw.projeto.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @Column(name = "cpf")
    private String Cpf;

    @Column(name = "email")
    private String email;

    public Aluno() {
    }

    public Aluno(String nome, Date dataNascimento, String cpf, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.Cpf = cpf;
        this.email = email;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }
}
