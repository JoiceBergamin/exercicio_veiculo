package com.exercicio.repositories;


import com.exercicio.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
     Optional<Veiculo> findByCpfProprietario(String cpfProprietario);
}
