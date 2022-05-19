package com.example.onlinelottery.Controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class ResorceCtler {
    List<String> verifyname = new ArrayList<>(Arrays.asList("8ur5", "25aa", "857k", "1348", "nllu"));

    @RequestMapping(value = "agreement", method = RequestMethod.GET)
    @ResponseBody
    String getAgreement(HttpServletRequest request, HttpServletResponse response) {
        return "没有用户使用协议！！！";
    }

    @GetMapping(value = "/getverify", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getVerify(HttpServletRequest request) throws IOException {
        Random random = new Random();
        int r = random.nextInt(5);
        request.getSession().setAttribute("verify",verifyname.get(r));
        File file = new File("src/main/resources/verifypic/" + verifyname.get(r) + ".png");
        FileInputStream input = new FileInputStream(file);
        byte[] bytes = new byte[input.available()];
        input.read(bytes, 0, input.available());
        input.close();
        return bytes;
    }
}
