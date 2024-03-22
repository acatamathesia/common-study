package org.commonstudy.others.inits;

/**
 * @Author: 铠甲勇士
 * @Description:
 * @Date: create in 2024/3/22 22:50
 */
public class InitTestDemo extends InitTestFather{

    public InitTestDemo() {
        System.out.println("构造器初始化InitTestDemo");
    }

    {
        System.out.println("静态代码块初始化--InitTestDemo");
    }

    public static void main(String[] args) {
        new InitTestDemo();

        int a = 0;
        {
            int b = 1;
            System.out.println(a);
        }
        // 无法访问到b
//        System.out.println(b);
    }


}
