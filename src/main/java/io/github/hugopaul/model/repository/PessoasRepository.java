package io.github.hugopaul.model.repository;

import io.github.hugopaul.model.entity.PessoasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<PessoasEntity, Integer> {
}
