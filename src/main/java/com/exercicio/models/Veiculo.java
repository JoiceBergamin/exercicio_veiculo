package com.exercicio.models;

import com.exercicio.models.dtos.VeiculoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
@Entity
@Table(name = "TABLE_VEICULOS")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo")
    private Long id;

    @NotNull @NotBlank
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao;

    @NotNull
    private double valorAquisicao;

    @NotNull @NotBlank
    private String nomeProprietario;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cpfProprietario;

    public Veiculo() {
    }

    public Veiculo(Long id, String descricao, LocalDate dataAquisicao, double valorAquisicao, String nomeProprietario, String cpfProprietario) {
        this.id = id;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.nomeProprietario = nomeProprietario;
        this.cpfProprietario = cpfProprietario;
    }

    public Veiculo(VeiculoDTO dto) {
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.dataAquisicao = dto.getDataAquisicao();
        this.valorAquisicao = dto.getValorAquisicao();
        this.nomeProprietario = dto.getNomeProprietario();
        this.cpfProprietario = dto.getCpfProprietario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    @NotNull
    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull @NotBlank String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(@NotNull @NotBlank String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public @NotNull @NotBlank String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(@NotNull @NotBlank String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }
}
