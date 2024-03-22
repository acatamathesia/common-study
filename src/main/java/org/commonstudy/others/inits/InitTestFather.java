package org.commonstudy.others.inits;

/**
 * @Author: 铠甲勇士
 * @Description:
 * @Date: create in 2024/3/22 22:51
 */
public class InitTestFather {

    // 类信息，元数据信息在类加载阶段进入方法区
    final static String MESSAGE = "NO_MESSAGE";

    public InitTestFather() {
        System.out.println("构造器初始化-InitTestFather");
    }

    {
        System.out.println(MESSAGE);
        Class<? extends InitTestFather> clzz = this.getClass();
        System.out.println(clzz.getSimpleName());
        System.out.println(clzz.getClassLoader().getName());
        System.out.println(clzz.getClassLoader().getUnnamedModule().getName());
        System.out.println("静态代码块初始化-InitTestFather");
    }

}
