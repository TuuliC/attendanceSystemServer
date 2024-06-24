package com.tuuli.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuuli.common.KaptchaNotMatchException;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author tuuli
 * @time Created in 2024/3/31 15:03
 * @description
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    public static final String FORM_KAPTCHA_KEY = "kaptcha";

    private String kaptchaParameter = FORM_KAPTCHA_KEY;

    public String getKaptchaParameter() {
        return kaptchaParameter;
    }

    public void setKaptchaParameter(String kaptchaParameter) {
        this.kaptchaParameter = kaptchaParameter;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //判断是否是post请求
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        //判断是否是json格式类型数据
        if (request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
            //从json获取用户名密码进行认证
            try {
                Map<String, String> userInfo = new ObjectMapper().readValue(request.getInputStream(), Map.class);
                System.out.println("userInfo = " + userInfo);
                String code = userInfo.get(getKaptchaParameter());//用来获取数据中验证码
                String username = userInfo.get(getUsernameParameter());
                String password = userInfo.get(getPasswordParameter());
                //获取 session 中验证码
                String sessionVerifyCode = (String) request.getSession().getAttribute("kaptcha");

                // 测试时免验证码登录
                /*sessionVerifyCode = "8888";
                code = sessionVerifyCode;*/

                String rememberValue = userInfo.get(AbstractRememberMeServices.DEFAULT_PARAMETER);
                if (!ObjectUtils.isEmpty(rememberValue)) {
                    request.setAttribute(AbstractRememberMeServices.DEFAULT_PARAMETER, rememberValue);
                }
                //打印用户登录信息日志
                logger.info("username = " + username + "\tpassword = " + password + "\ttrue-code = " + sessionVerifyCode +
                        "\t user-code = " + code + "\tremember-me = " + rememberValue);
                if (!ObjectUtils.isEmpty(code) && !ObjectUtils.isEmpty(sessionVerifyCode) &&
                        code.equalsIgnoreCase(sessionVerifyCode)) {
                    //获取用户名和密码认证
                    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
                    setDetails(request, authRequest);
                    return this.getAuthenticationManager().authenticate(authRequest);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //验证码错误
            throw new KaptchaNotMatchException("验证码不匹配!");
        }
        //表单认证
        return super.attemptAuthentication(request, response);
    }
}
