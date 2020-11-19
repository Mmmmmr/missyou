package com.jiang.missyou.api.v1;

import com.jiang.missyou.model.Banner;
import com.jiang.missyou.model.Spu;
import com.jiang.missyou.service.BannerService;
import com.jiang.missyou.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {

    @Autowired
    private SpuService spuService;


    @PostMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive int id) {
        return this.spuService.getSpu(id);
    }

    @PostMapping("/latest")
    public List<Spu> getLatestSpuList() {
        return this.spuService.getLatestSpuList();
    }
}
