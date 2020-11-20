package com.jiang.missyou.service;

import com.jiang.missyou.model.Spu;
import com.jiang.missyou.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuService {
    @Autowired
    SpuRepository spuRepository;

    public Spu getSpu(int id) {
        return  spuRepository.findOneById(id);

    }

    public Page<Spu> getLatestSpuList (Integer pageNum, Integer count) {
        Pageable page = PageRequest.of(pageNum, count, Sort.by("createTime").descending());
        return this.spuRepository.findAll(page);
    }
}
