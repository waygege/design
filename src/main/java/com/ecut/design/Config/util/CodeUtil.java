package com.ecut.design.Config.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class CodeUtil {

    /**
     * 生成6位随机数字的字符串
     *
     * @return String 6位数字字符串
     */
    public static String generate6BitDigital() {
        return ("" + (Math.random() + 0.1) * 1000000).substring(0, 6)+new Date ().getTime ();
    }

    public static void main (String[] args) {
        System.out.println ( generate6BitDigital ());
        System.out.println ( generate6BitDigital ().substring (6,19));
    }
}
