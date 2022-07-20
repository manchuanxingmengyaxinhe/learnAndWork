package com.example.jsonschemal.jsongenerator.enity;

/**
 * @author zhu.kaize
 * @version 1.0
 * @description 基础枚举范型接口
 * @date 2022/07/05
 **/
public interface GenericBaseEnum<R> {

    /**
     * 获取编码
     *
     * @return java.lang.Integer
     * @creator zhu.kaize
     * @date 2022/07/05
     */
    R getCode ();

    /**
     * 获取文本
     *
     * @return java.lang.String
     * @creator zhu.kaize
     * @date 2022/07/05
     */
    String getText ();

}
