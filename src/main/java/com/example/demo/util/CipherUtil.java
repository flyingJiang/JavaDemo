package com.example.demo.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-08-01 19:03
 **/
@Component
public class CipherUtil {

    private static final String secretKey = "";

    private SecretKeySpec secretKeySpec;

    public String encrypt(String content) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(content.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    @PostConstruct
    public void getPrivateKey() throws InvalidKeySpecException, IOException, NoSuchAlgorithmException {
        byte[] key = secretKey.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        this.secretKeySpec = new SecretKeySpec(key, "AES");
    }
}