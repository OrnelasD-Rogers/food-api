package com.ornelas.foodapi.domain.repository;




import com.ornelas.foodapi.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
