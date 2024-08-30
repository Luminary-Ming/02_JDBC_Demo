package com.demo01;

import org.junit.jupiter.api.Test;

/**
 * junit 单元测试：在不使用main方法作为程序的入口，可以去测试（运行）其他任何的方法。
 * @Test: 注解 使用条件如下：
 * 方法必须满足：公开的（访问权限），没有返回值，没有参数
 */
public class JunitDemo {
    @Test
    public void test(){
        System.out.println(add(5,6));  // 11
    }

    public int add(int a,int b){
        return a+b;
    }
}
