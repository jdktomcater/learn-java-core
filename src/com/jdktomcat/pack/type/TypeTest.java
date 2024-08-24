package com.jdktomcat.pack.type;

import com.jdktomcat.pack.type.handler.TypeHandler;

/**
 * 类描述：
 *
 * @author 汤旗
 * @date 2019-10-28 11:30
 */
public class TypeTest {

    public static void main(String[] args) {
        TypeHandler<TargetBean> typeHandler = new TypeHandler<>();
        TargetBean targetBean = new TargetBean();
        typeHandler.handle(targetBean);
    }
}
