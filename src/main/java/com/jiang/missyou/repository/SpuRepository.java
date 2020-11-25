package com.jiang.missyou.repository;

import com.jiang.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpuRepository extends JpaRepository<Spu, Integer> {
    Spu findOneById(int id);
    Page<Spu> findByCategoryIdOrderByCreateTimeDesc(Long cid, Pageable page);
    Page<Spu> findByRootCategoryIdOrderByCreateTimeDesc(Long cid,Pageable page);
}
