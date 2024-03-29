package org.commonstudy.inits;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: 铠甲勇士
 * @Description:
 * @Date: create in 2024/3/26 8:01
 */
@Component
public class Tools implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }


    public static void testIsPrepare() {
        System.out.println(context.getApplicationName());
    }
}
