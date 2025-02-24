package com.exercicio.resources;

import com.exercicio.models.Veiculo;
import com.exercicio.models.dtos.VeiculoDTO;
import com.exercicio.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll(){
        return ResponseEntity.ok().body(veiculoService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id){
      Veiculo obj = this.veiculoService.findById(id);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }
    @GetMapping(value = "/cpfProprietario/{cpfProprietario}")
    public ResponseEntity<VeiculoDTO> findByCpfProprietario(@PathVariable String cpfProprietario){
        Veiculo obj = this.veiculoService.findByCpfProprietario(cpfProprietario);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }
    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO dto){
        Veiculo veiculo = veiculoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
