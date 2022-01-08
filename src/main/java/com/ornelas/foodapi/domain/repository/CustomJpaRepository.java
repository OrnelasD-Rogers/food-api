package com.ornelas.foodapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

//Diz que o Spring não deve instanciar uma implementação para esta interface
@NoRepositoryBean
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {


    Optional<T> buscarPrimeiro();
}
