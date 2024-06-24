package com.tuuli.controller;

import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class VerifyCodeController {

    private final Producer producer;

    @Autowired
    public VerifyCodeController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/vcimg")
    public String getVerifyCode(HttpSession session) throws IOException {
        //1.生成验证码
        String text = producer.createText();
        System.out.println("code = " + text);
        //2.放入 session
        session.setAttribute("kaptcha", text);
        //3.生成图片
        BufferedImage bi = producer.createImage(text);
        FastByteArrayOutputStream fos = new FastByteArrayOutputStream();
        ImageIO.write(bi, "jpg", fos);
        //4.返回 base64
//        System.out.println("Base64.encodeBase64String(fos.toByteArray()) = " + Base64.encodeBase64String(fos.toByteArray()));
        return Base64.encodeBase64String(fos.toByteArray());
    }
}