package com.jiang.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.jiang.missyou.bo.PageCounter;
import com.jiang.missyou.exception.http.NotFoundException;
import com.jiang.missyou.model.Banner;
import com.jiang.missyou.model.Spu;
import com.jiang.missyou.service.BannerService;
import com.jiang.missyou.service.SpuService;
import com.jiang.missyou.util.CommonUtil;
import com.jiang.missyou.vo.PagingDozer;
import com.jiang.missyou.vo.SpuSimplifyVO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {

    @Autowired
    private SpuService spuService;


    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive Long id) {
        Spu spu = this.spuService.getSpu(id);
        if(spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/id/{id}/simplify")
    public SpuSimplifyVO getSimplifySpu(@PathVariable @Positive(message = "{id.positive}") Long id) {
        Spu spu = this.spuService.getSpu(id);
        SpuSimplifyVO vo = new SpuSimplifyVO();
        BeanUtils.copyProperties(spu, vo);
        return vo;
    }

    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer start,
                                                            @RequestParam(defaultValue = "20") Integer count) {
        PageCounter pageCounter = CommonUtil.covertToPageParameter(start, count);
        Page<Spu> spuList = this.spuService.getLatestSpuList(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(spuList, SpuSimplifyVO.class);
    }

    @PostMapping("/by/categroy/{id}")
    public PagingDozer<Spu, SpuSimplifyVO> getByCategoryId(@PathVariable @Positive(message = "{id.positive}") Long id,
                                                           @RequestParam(name = "is_root") Boolean isRoot,
                                                           @RequestParam(name = "start", defaultValue = "0") Integer start,
                                                           @RequestParam(name = "count", defaultValue = "20") Integer count) {
        PageCounter pageCounter = CommonUtil.covertToPageParameter(start, count);
        Page<Spu> spuList = this.spuService.getByCategory(id,  isRoot, pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(spuList, SpuSimplifyVO.class);
    }
}
