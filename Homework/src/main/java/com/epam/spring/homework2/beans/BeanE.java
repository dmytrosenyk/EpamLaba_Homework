package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.ValidationMark;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@ValidationMark
public class BeanE {
    @Value("BeanE")
    private String name;

    @Value("75")
    private int value;

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("BeanE postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanE preDestroy");
    }

}
