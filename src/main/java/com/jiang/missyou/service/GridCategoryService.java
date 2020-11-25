package com.jiang.missyou.service;

import com.jiang.missyou.model.GridCategory;
import com.jiang.missyou.repository.GridCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryService {
    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    public List<GridCategory> findAll() {
        return gridCategoryRepository.findAll();
    }
}
