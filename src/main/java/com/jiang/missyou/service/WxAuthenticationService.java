package com.jiang.missyou.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiang.missyou.exception.http.ParameterException;
import com.jiang.missyou.model.User;
import com.jiang.missyou.repository.UserRepository;
import com.jiang.missyou.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class WxAuthenticationService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Value("${wx.code2Session}")
    private String code2SessionUrl;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.appsecret}")
    private String appsecret;

    public String code2Session(String code) {
        String url = MessageFormat.format(this.code2SessionUrl, this.appid, this.appsecret, code);
        RestTemplate rest = new RestTemplate();
        Map<String, Object> session = new HashMap<>();
        String sessionText = rest.getForObject(url,  String.class);
        try {
            session = objectMapper.readValue(sessionText, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return this.registerUser(session);
    }

    private String registerUser(Map<String, Object> session) {
        String openid = (String)session.get("openid");
        if (openid == null){
            throw new ParameterException(20004);
        }
        Optional<User> userOptional = this.userRepository.findByOpenid(openid);
//        userOptional.ifPresentOrElse(Consummer, Runable)
        if(userOptional.isPresent()){
            // TODO:返回JWT令牌
            // 数字等级
            return JwtToken.makeToken(userOptional.get().getId());
        }
        User user = User.builder()
                .openid(openid)
                .build();
        userRepository.save(user);
        // TODO:返回JWT令牌
        Long uid = user.getId();
        return JwtToken.makeToken(uid);
    }
}
