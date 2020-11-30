package com.example.provider.security;

import com.alibaba.fastjson.JSON;
import com.example.provider.model.TokenJsonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yangpengcheng
 * @ClassName SecurityFailedHandler
 * @Description:
 * @date 2020/11/2017:47
 */
@Component
public class SecurityFailedHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        TokenJsonResult tokenJsonResult=new TokenJsonResult(false,"");
        out.write(JSON.toJSONString(tokenJsonResult));
        out.flush();
    }
}
