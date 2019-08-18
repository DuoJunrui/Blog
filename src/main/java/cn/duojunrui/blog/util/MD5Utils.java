package cn.duojunrui.blog.util;

import org.springframework.util.DigestUtils;

/**
 * @Description: 密码MD5加密工具类
 * @Author: Duojunrui
 * @Date: 2019/8/18 15:34
 */
public class MD5Utils {

    /**
     * 盐值，用于混交md5
     */
    private static final String slat = "181!@#$..2520";

    /**
     * 生成md5，这里使用Spring自带的DigestUtils工具类
     * @param str
     * @return md5
     */
    public static String getMD5(String str) {
        String base = str +"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

}
