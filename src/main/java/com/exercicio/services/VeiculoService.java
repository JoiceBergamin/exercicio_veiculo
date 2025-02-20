package com.exercicio.services;

import com.exercicio.models.dtos.VeiculoDTO;
import com.exercicio.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoDTO> findAll(){
//repository ta buscando todos os registros de veiculo, retorna uma lista de objetos Veiculo e convertendo para stream
        return veiculoRepository.findAll().stream().map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());
    }
}

//stream() transforma uma coleção como List, Set ou Map em um fluxo de dados (Stream<T>)
//permitindo algumas operações encadeadas como filter(), map() e outros
//map() pode usado para transformar elementos de um Stream em outro formato (conversão de tipos)
//obj -> new VeiculoDTO(obj) ---> expressão lambda onde o obj representa cada elemento da lista original (Veiculo)
//e ele é passado como argumento para criar um novo VeiculoDTO
//collect(Collectors.toList())pode ser usado para converter uma stream em uma List