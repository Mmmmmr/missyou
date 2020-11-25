package com.jiang.missyou.api.v1;

import com.jiang.missyou.dto.TokenGetDto;
import com.jiang.missyou.exception.http.NotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("token")
@RestController
public class TokenController {
    @PostMapping("")
    public Map<String, String> getToke(@RequestBody @Validated TokenGetDto userData) {
        Map<String, String> map = new HashMap<>();
        String token = null;
        switch (userData.getLoginType()) {
            case USER_WX:
                break;
            case USER_EMAIL:
                break;
            default:
                throw new NotFoundException(10003);
        }
        return null;
    }

}
