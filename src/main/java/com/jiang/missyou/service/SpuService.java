package com.jiang.missyou.service;

import com.jiang.missyou.exception.http.NotFoundException;
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
    private SpuRepository spuRepository;

    public Spu getSpu(Long id) {
        Spu spu =  spuRepository.findOneById(id);
        if(spu ==  null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    public Page<Spu> getLatestSpuList (Integer pageNum, Integer count) {
        Pageable page = PageRequest.of(pageNum, count, Sort.by("createTime").descending());
        return this.spuRepository.findAll(page);
    }

    public Page<Spu> getByCategory(Long cid, Boolean isRoot, Integer pageNum, Integer size) {
        Pageable page = PageRequest.of(pageNum, size);
        if(isRoot) {
            return this.spuRepository.findByRootCategoryIdOrderByCreateTimeDesc(cid, page);

        } else {
            return this.spuRepository.findByCategoryIdOrderByCreateTimeDesc(cid, page);
        }
    }
}
