package com.ornelas.foodapi.domain.repository;

import com.ornelas.foodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findCozinhasByNome(String nome);

    boolean existsByNome(String nome);
}
