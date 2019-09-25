package com.cest.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 前端传入密码进行md5两次加密
 * Created by cestlavie on 2019/9/23.
 */
@Slf4j
public class MD5Util {

    public static final String salt = "abcdefgh";

    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

    /**
     * 输入密码进行md5加密
     * @param inputPass
     * @return
     */
    public static String inputPassToEncodePass(String inputPass){
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(4) + salt.charAt(6);
        log.info(str);
        return md5(str);
    }

    /**
     * 已加密密码入库进行加密
     * @param encodePass
     * @return
     */
    public static String EncodePassToDBPass(String encodePass){
        String str = "" + salt.charAt(0) + salt.charAt(2) + encodePass + salt.charAt(4) + salt.charAt(6);
        log.info(str);
        return md5(str);
    }

    /**
     * 从输入密码到入库进行两次md5加密
     * @param inputPass
     * @return
     */
    public static String inputPassToDBPass(String inputPass){
        String enCodePass = inputPassToEncodePass(inputPass);
        String dbPass = EncodePassToDBPass(enCodePass);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(md5("211"));
        System.out.println(inputPassToEncodePass("211"));
        System.out.println(EncodePassToDBPass("211"));

        //密码123456
        System.out.println(inputPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9"));
    }
}
