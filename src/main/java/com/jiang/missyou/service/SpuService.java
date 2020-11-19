package com.jiang.missyou.service;

import com.jiang.missyou.model.Spu;
import com.jiang.missyou.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuService {
    @Autowired
    SpuRepository spuRepository;

    public Spu getSpu(int id) {
        return  spuRepository.findOneById(id);

    }

    public List<Spu> getLatestSpuList () {
        return this.spuRepository.findAll();
    }
}
