package com.jiang.missyou.repository;

import com.jiang.missyou.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
