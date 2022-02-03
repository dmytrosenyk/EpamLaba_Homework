package com.epam.spring.homework2.other;

import com.epam.spring.homework2.validation.ValidationMark;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ValidationMark.class)) {
            getFieldByNameAndType(bean, "name", String.class)
                    .map(field -> getValue(bean, field))
                    .filter(value -> !value.isPresent())
                    .ifPresent(field -> System.out.println(beanName + ". 'name' can't be null"));
            getFieldByNameAndType(bean, "value", int.class)
                    .flatMap(o -> this.<Integer>getValue(bean, o))
                    .filter(value -> value < 0)
                    .ifPresent(value -> System.out.println(beanName + ". 'value' must be greater than zero"));
        }
        return bean;
    }

    private <T> Optional<Field> getFieldByNameAndType(Object bean, String fieldName, Class<T> clazz) {
        Optional<Field> fieldOptional;

        try {
            Field field = bean.getClass().getDeclaredField(fieldName);
            if (field.getType().equals(clazz)) {
                fieldOptional = Optional.of(field);
            } else {
                fieldOptional = Optional.empty();
            }
        } catch (NoSuchFieldException e) {
            fieldOptional = Optional.empty();
        }

        return fieldOptional;
    }

    @SuppressWarnings("unchecked")
    private <T> Optional<T> getValue(Object bean, Field field) {
        try {
            field.setAccessible(true);
            return Optional.of((T) field.get(bean));
        } catch (IllegalAccessException | NullPointerException e) {
            return Optional.empty();
        }
    }

}
