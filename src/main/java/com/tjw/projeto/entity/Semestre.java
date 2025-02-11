package com.tjw.projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ano;

    private int numeroSemestre;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    public Semestre() {
    }

    public Semestre(String ano, LocalDate dataInicio, LocalDate dataFim, int numeroSemestre) {
        this.ano = ano;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.numeroSemestre = numeroSemestre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getNumeroSemestre() {
        return numeroSemestre;
    }

    public void setNumeroSemestre(int numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
