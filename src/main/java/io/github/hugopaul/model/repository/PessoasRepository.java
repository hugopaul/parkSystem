package io.github.hugopaul.model.repository;

import io.github.hugopaul.model.entity.Carros;
import io.github.hugopaul.model.entity.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<Pessoas, Integer> {
}
