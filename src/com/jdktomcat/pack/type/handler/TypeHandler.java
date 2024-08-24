package com.jdktomcat.pack.type.handler;

import com.jdktomcat.pack.type.AbstractBean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-10-28 11:27
 */
public class TypeHandler<T extends AbstractBean> {

    public void handle(T target) {
        Class clazz = TypeHandler.class.getClass();
        // 非泛型类型，直接丢掉
        System.out.println(clazz.getName());
    }

}
