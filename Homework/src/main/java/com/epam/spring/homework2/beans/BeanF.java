package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.ValidationMark;
import org.springframework.beans.factory.annotation.Value;

@ValidationMark
public class BeanF {
    @Value("BeanF")
    private String name;

    @Value("8")
    private int value;

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
