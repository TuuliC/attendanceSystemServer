package com.tuuli.config;

import com.alibaba.fastjson.JSON;
import com.tuuli.common.R;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tuuli
 * @time Created in 2024/3/31 15:38
 * @description
 */
public class MyAuthenticationLogoutHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        R<String> r = R.success("退出成功");
        String s = JSON.toJSONString(r);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
    }
}
