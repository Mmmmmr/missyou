package com.jiang.missyou.repository;

import com.jiang.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpuRepository extends JpaRepository<Spu, Long> {
    Spu findOneById(int id);

    Page<Spu> findSpuBycategoryIdOrderByCreateTimeDesc();
}
