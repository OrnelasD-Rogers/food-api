package com.ornelas.foodapi.domain.repository;



import com.ornelas.foodapi.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
