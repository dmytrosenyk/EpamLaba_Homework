package com.epam.spring.homework2;

import com.epam.spring.homework2.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach((s) -> System.out.println(context.getBeanDefinition(s)));
        context.close();
    }
}
