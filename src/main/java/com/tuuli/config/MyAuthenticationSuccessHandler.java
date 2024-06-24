package com.tuuli.config;

import com.alibaba.fastjson.JSON;
import com.tuuli.common.R;
import com.tuuli.domain.UserInfo;
import com.tuuli.vo.UserVo;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tuuli
 * @time Created in 2024/3/30 21:41
 * @description
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserVo principal = (UserVo) authentication.getPrincipal();
        UserInfo userInfo = new UserInfo(principal.getId(), principal.getUsername(), null, principal.getRole());
        R<UserInfo> r = R.success(userInfo);
        String s = JSON.toJSONString(r);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
    }
}
