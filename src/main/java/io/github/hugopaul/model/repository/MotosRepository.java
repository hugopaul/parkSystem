package io.github.hugopaul.model.repository;

import io.github.hugopaul.model.entity.Carros;
import io.github.hugopaul.model.entity.Motos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotosRepository extends JpaRepository<Motos, Integer> {
}
