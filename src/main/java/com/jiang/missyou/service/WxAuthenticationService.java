package com.jiang.missyou.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiang.missyou.exception.http.ParamterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.Map;

@Service
public class WxAuthenticationService {
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${wx.code2Session}")
    private String code2SessionUrl;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.appsecret}")
    private String appsecret;

    public String code2Session(String code) {
        String url = MessageFormat.format(this.code2SessionUrl, this.appid, this.appsecret, code);
        RestTemplate rest = new RestTemplate();
        String sessionText = rest.getForObject(url,  String.class);
        try {
            Map<String, Object> session = objectMapper.readValue(sessionText, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String registerUser(Map<String, Object> session) {
        String openid = (String) session.get("openid");
        if(openid == null) {
            throw new ParamterException(20004);
        }
    }
}
