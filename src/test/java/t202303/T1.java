package t202303;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: JavaDemo
 * @description:
 * @author: jiangjianfei
 * @create: 2023-03-03 14:22
 **/
public class T1 {
    @Test
    public void test1() {
        Map<Long, Integer> result = new HashMap<>();
        System.out.println(result.getOrDefault(1L, 100));
    }

    @Test
    public void test2() {

        List<String> orderTypeList = new ArrayList<>();
        orderTypeList.add("1");
        orderTypeList.add("2");
        orderTypeList.add("3");
        if (orderTypeList.contains(null)) {
            System.out.println("12");
        } else {
            System.out.println("34");

        }

    }
}
