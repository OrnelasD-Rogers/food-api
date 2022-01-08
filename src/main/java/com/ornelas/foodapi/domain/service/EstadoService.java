package com.ornelas.foodapi.domain.service;

import com.ornelas.foodapi.domain.exception.EntidadeEmUsoException;
import com.ornelas.foodapi.domain.exception.EstadoNaoEncontradoException;
import com.ornelas.foodapi.domain.model.Estado;
import com.ornelas.foodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public Estado buscar(Long id){
        return estadoRepository.findById(id)
                .orElseThrow(() -> new EstadoNaoEncontradoException(id));
    }

    public List<Estado> listar(){
        return estadoRepository.findAll();
    }

    @Transactional
    public Estado salvar(Estado estado){
        return estadoRepository.save(estado);
    }

    @Transactional
    public void remover(Long id){
        try{
            estadoRepository.deleteById(id);
            estadoRepository.flush();
        }catch (EmptyResultDataAccessException e) {
            throw new EstadoNaoEncontradoException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Estado de código %d não pode ser removido pois está em uso", id));
        }

    }
}
