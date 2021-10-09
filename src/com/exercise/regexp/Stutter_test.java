package com.exercise.regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//结巴去重
public class Stutter_test {
    private static String sentence = "吗.....咿咿咿咿..呀呀..嘿";
    @Test
    public void resolveRepeat(){
        //一句话去重，可参考主方法里的过程理解
        String res = Pattern.compile("(.)\\1+").matcher(sentence).replaceAll("$1");
        System.out.println(res);
    }
    public static void main(String[] args) {

        System.out.println(sentence);
        Pattern pattern = Pattern.compile("\\.+");
        Matcher matcher = pattern.matcher(sentence);
        String str_noDot = matcher.replaceAll("");
        pattern = Pattern.compile("([\u0391-\uffe5])\\1+");
        Matcher matcher1 = pattern.matcher(str_noDot);
        //$x ~ \\x
        String str_noRepeat = matcher1.replaceAll("$1");
        System.out.println("去重\n"+ str_noRepeat);
    }
}
