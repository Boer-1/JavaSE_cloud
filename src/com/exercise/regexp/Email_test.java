package com.exercise.regexp;

import java.util.regex.Pattern;

/**
 * 假定规则是
 * 只能有一个@
 * \@前面是用户名，可以是a-z,A-Z,0-9,_,-字符
 * \@后面是域名，并且域名只能是英文字母，比如sohu.com;tsinghua.org.cn
 */
public class Email_test {
    public static void main(String[] args) {
        String test ="zno@qq.com";

        String regStr = "^[\\w_-]+@([a-z]+\\.)+[a-z]+$";
        //正则
        System.out.println(Pattern.matches(regStr, test));
        //字符串
        System.out.println(test.matches(regStr));
    }
}
