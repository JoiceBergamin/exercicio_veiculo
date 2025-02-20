package com.exercicio.models.dtos;

import com.exercicio.models.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class VeiculoDTO {

    private Long id;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode estar vazio")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao = LocalDate.now();

    @NotNull(message = "O campo valor de aquisição não pode ser nulo")
    private double valorAquisicao;

    @NotNull(message = "O campo nome do proprietário não pode ser nulo")
    @NotBlank(message = "O campo nome do proprietário não pode ser branco")
    private String nomeProprietario;

    @NotNull(message = "O campo cpf do proprietário não pode ser nulo")
    @NotBlank(message = "O campo cpf do proprietário não pode ser branco")
    private String cpfProprietario;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.descricao = veiculo.getDescricao();
        this.dataAquisicao = veiculo.getDataAquisicao();
        this.valorAquisicao = veiculo.getValorAquisicao();
        this.nomeProprietario = veiculo.getNomeProprietario();
        this.cpfProprietario = veiculo.getCpfProprietario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descricao não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição não pode ser nulo") @NotBlank(message = "O campo descricao não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    @NotNull(message = "O campo valor de aquisição não pode ser nulo")
    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull(message = "O campo valor de aquisição não pode ser nulo") double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull(message = "O campo nome do proprietário não pode ser nulo") @NotBlank(message = "O campo nome do proprietário não pode ser branco") String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(@NotNull(message = "O campo nome do proprietário não pode ser nulo") @NotBlank(message = "O campo nome do proprietário não pode ser branco") String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public @NotNull(message = "O campo cpf do proprietário não pode ser nulo") @NotBlank(message = "O campo cpf do proprietário não pode ser branco") String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(@NotNull(message = "O campo cpf do proprietário não pode ser nulo") @NotBlank(message = "O campo cpf do proprietário não pode ser branco") String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }
}
