package com.exercicio.services;

import com.exercicio.models.Veiculo;
import com.exercicio.models.dtos.VeiculoDTO;
import com.exercicio.repositories.VeiculoRepository;
import com.exercicio.services.exceptions.DataIntegrityViolationException;
import com.exercicio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoDTO> findAll(){
//repository ta buscando todos os registros de veiculo, retorna uma lista de objetos Veiculo e convertendo para stream
        return veiculoRepository.findAll().stream().map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());
    }
    public Veiculo findById(Long id){
        Optional<Veiculo> obj = veiculoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veiculo não encontrado! Id: " + id));
    }

    public Veiculo findByCpfProprietario(String cpfProprietario){
        Optional<Veiculo> obj = veiculoRepository.findByCpfProprietario(cpfProprietario);
        return obj.orElseThrow(() -> new ObjectNotFoundException("CPF do proprietario não encontrado! cpfProprietario: " + cpfProprietario));
    }
    public void validarVeiculo(VeiculoDTO dto){
        Optional<Veiculo> obj = veiculoRepository.findByCpfProprietario(dto.getCpfProprietario());
        if(obj.isPresent() && obj.get().getId() != dto.getId()){
            throw new DataIntegrityViolationException("Cpf do Proprietario ja cadastrado!");
        }
    }

    public Veiculo create(VeiculoDTO dto){
dto.setId(null);
validarVeiculo(dto);
Veiculo obj = new Veiculo(dto);
return veiculoRepository.save(obj);
    }

    public Veiculo update(Long id, VeiculoDTO objDto){
        objDto.setId(id);
        Veiculo oldObj = findById(id);
        oldObj = new Veiculo(objDto);
        return veiculoRepository.save(oldObj);
    }
    public void delete(Long id){
        Veiculo obj = findById(id);
        veiculoRepository.deleteById(id);
    }
}


//stream() transforma uma coleção como List, Set ou Map em um fluxo de dados (Stream<T>)
//permitindo algumas operações encadeadas como filter(), map() e outros
//map() pode usado para transformar elementos de um Stream em outro formato (conversão de tipos)
//obj -> new VeiculoDTO(obj) ---> expressão lambda onde o obj representa cada elemento da lista original (Veiculo)
//e ele é passado como argumento para criar um novo VeiculoDTO
//collect(Collectors.toList())pode ser usado para converter uma stream em uma List