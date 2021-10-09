package com.exercise.regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_reg {
    //尝试{n,m},及贪心
    @Test
    public void t_1(){
        String content = "asdfasdkmlkm121313215ssss*&^%^ %  $";
        String regStr = "s{3,4}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
    //验证汉字
    @Test
    public void t_2(){
        String content = "风动幡动";
        String regStr = "^[\u0391-\uffe5]+$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if(matcher.find()){
            System.out.println("right");
        }else {
            System.out.println("wrong");
        }
    }
    //验证邮政编码格式
    @Test
    public void t_3(){
        String contentR = "300450";
        String contentW = "3004501";
        String regStr = "^[1-9]\\d{5}$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(contentR);
        if (matcher.find()) {
            System.out.println("right");
        }
        Matcher matcher1 = pattern.matcher(contentW);
        if (matcher.find()) {
            System.out.println("wrong");
        }
    }
    //验证URL格式
    @Test
    public void t_4(){
        //String content = "https://www.bilibili.com/video/BV1fh411y7R8?from=search&seid=1831060912083761326";
        String content = "http://edu.3dsmax.tech/yg/bilibili/my6652/pc/qg/05-51/index.html#201211-1?track_id=jMc0jn-hm-yHrNfVad37YdhOUh41XYmjlss9zocM26gspY5ArwWuxb4wYWpmh2Q7GzR7doU0wLkViEhUlO1qNtukyAgake2jG1bTd23lR57XzV83E9bAXWkStcAh4j9Dz7a87ThGlqgdCZ2zpQy33a0SVNMfmJLSNnDzJ71TU68Rc-3PKE7VA3kYzjk4RrKU";

        /**
         * 思路
         * 1. 先确定 url 的开始部分 https:// | http://
         * 2.然后通过 ([\w-]+\.)+[\w-]+ 匹配 www.bilibili.com
         * 3. /video/BV1fh411y7R8?from=sear 匹配(\/[\w-?=&/%.#]*)?
         */
        String regStr = "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";//注意：[. ? *]表示匹配就是.本身

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if(matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }

        //这里如果使用Pattern的matches 整体匹配 比较简洁
        System.out.println(Pattern.matches(regStr, content));//
    }
    //反向引用，匹配两个连续的相同的数字
    @Test
    public void t_5(){
        String content = "1651 1 1515 61561 23 55 5 55 56 123 ";
        String regStr = "(\\d)\\1";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
