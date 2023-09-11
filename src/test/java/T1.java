
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-08-03 10:38
 **/
public class T1 {
    @Test
    public void t1() {
        String s = "AC09876";
        System.out.println(s.substring(0, 3));
    }

    @Test
    public void t2() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("3");
        List<String> list2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(JSONUtil.toJsonStr(list2));


    }

    @Test
    public void t3() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("3");
        List<String> list2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(JSONUtil.toJsonStr(list2));
        list2 = list2.subList(0, 2);
        System.out.println(JSONUtil.toJsonStr(list2));


    }

    @Test
    public void t4() throws UnsupportedEncodingException {
        String s = "1S8oc%2FcPwPiSgWH0OO9yow%3D%3D";
        String s1 = "1S8oc/cPwPiSgWH0OO9yow==";
        String s2 = java.net.URLDecoder.decode(s, "UTF-8");
        System.out.println(s2);
        String s3 = java.net.URLDecoder.decode(s1, "UTF-8");
        System.out.println(s3);
    }

}
