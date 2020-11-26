package com.jiang.missyou.api.v1;

import com.jiang.missyou.dto.TokenGetDto;
import com.jiang.missyou.exception.http.NotFoundException;
import com.jiang.missyou.service.WxAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("token")
@RestController
public class TokenController {
    @Autowired
    private WxAuthenticationService wxAuthenticationService;

    @PostMapping()
    public Map<String, String> getToke(@RequestBody @Validated TokenGetDto userData) {
        Map<String, String> map = new HashMap<>();
        String token = null;
        switch (userData.getType()) {
            case USER_WX:
                wxAuthenticationService.code2Session(userData.getAccount());
                break;
            case USER_EMAIL:
                break;
            default:
                throw new NotFoundException(10003);
        }
        return null;
    }

}
