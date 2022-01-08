package com.ornelas.foodapi.domain.service;

import com.ornelas.foodapi.domain.exception.CidadeNaoEncontradaException;
import com.ornelas.foodapi.domain.exception.EstadoNaoEncontradoException;
import com.ornelas.foodapi.domain.exception.NegocioException;
import com.ornelas.foodapi.domain.model.Cidade;
import com.ornelas.foodapi.domain.model.Estado;
import com.ornelas.foodapi.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoService estadoService;

    public List<Cidade> listar(){
        return cidadeRepository.findAll();
    }

    public Cidade buscar(Long id){
        return cidadeRepository.findById(id)
                .orElseThrow(()-> new CidadeNaoEncontradaException(id)
                );
    }

    @Transactional
    public Cidade salvar(Cidade cidade){
        try {
            Long estadoId = cidade.getEstado().getId();
            Estado estado = estadoService.buscar(estadoId);
            cidade.setEstado(estado);
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
        return cidadeRepository.save(cidade);
    }

    @Transactional
    public void remover(Long id){
        try{
            cidadeRepository.deleteById(id);
            cidadeRepository.flush();
        }catch (EmptyResultDataAccessException e){
            throw new CidadeNaoEncontradaException(id);
        }
    }



}
