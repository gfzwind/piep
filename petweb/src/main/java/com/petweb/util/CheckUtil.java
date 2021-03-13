package com.petweb.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.regex.Pattern;

/**
 * Create By yushe on 2020/5/8
 */

@Component
public class CheckUtil {
    public static boolean isIntNum(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    @PostConstruct
    public void init() {}
}
