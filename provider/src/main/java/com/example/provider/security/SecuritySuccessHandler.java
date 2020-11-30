package com.example.provider.security;

import com.alibaba.fastjson.JSON;
import com.example.provider.model.TokenJsonResult;
import com.example.provider.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yangpengcheng
 * @ClassName SecuritySuccessHandler
 * @Description:
 * @date 2020/11/2017:46
 */
@Component
public class SecuritySuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        String token=jwtUtils.generateToken(userDetails);
        TokenJsonResult tokenJsonResult=new TokenJsonResult(true,token);
        out.write(JSON.toJSONString(tokenJsonResult));
        out.flush();
    }
}
