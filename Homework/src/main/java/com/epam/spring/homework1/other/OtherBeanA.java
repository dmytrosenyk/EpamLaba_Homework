package com.epam.spring.homework1.other;

import com.epam.spring.homework1.beans.BeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherBeanA {

    private BeanA beanA;
    @Autowired
    public OtherBeanA(BeanA beanA){
        this.beanA = beanA;
        System.out.println(this.getClass().getSimpleName()+"---"+this.beanA.getClass().getSimpleName()+" injected with constructor");
    }
}
