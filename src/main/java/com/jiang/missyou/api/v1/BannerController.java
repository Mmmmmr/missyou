package com.jiang.missyou.api.v1;

import com.jiang.missyou.dto.PersonDTO;
import com.jiang.missyou.exception.http.NotFoundException;
import com.jiang.missyou.model.Banner;
import com.jiang.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;


    @PostMapping("/test/{name}")
    public Banner test(@PathVariable String  name) {
        Banner banner =  bannerService.getByName(name);
        if(banner == null) {
            throw new NotFoundException(30005);
        }
        return banner;
    }
}
