package org.commonstudy.others.streams;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @Author: 铠甲勇士
 * @Description:
 * @Date: create in 2024/3/24 10:59
 */
public class Gernerate {

    public static Supplier<Integer> randomInt = () -> new Random().nextInt(50);


}
