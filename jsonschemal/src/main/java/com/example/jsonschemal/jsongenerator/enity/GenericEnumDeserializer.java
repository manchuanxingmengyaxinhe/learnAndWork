package com.example.jsonschemal.jsongenerator.enity;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

/**
 * jackson枚举反序列化器
 * @author zhu.kaize
 * @version 1.0
 */
public class GenericEnumDeserializer<R> implements ObjectDeserializer {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object o) {
        final JSONLexer lexer = parser.lexer;
        Class cls = (Class) type;
        Object[] enumConstants = cls.getEnumConstants();
        if (GenericBaseEnum.class.isAssignableFrom(cls)) {
            for (Object enumConstant : enumConstants) {
                GenericBaseEnum<R> baseEnum = (GenericBaseEnum<R>) enumConstant;
                R code = baseEnum.getCode();
                Object v = null;
                if (code instanceof String) {
                    v = lexer.stringVal();
                } else if (code instanceof Integer) {
                    v = lexer.intValue();
                } else if (code instanceof Long) {
                    v = lexer.longValue();
                }
                if (baseEnum.getCode().equals((R)v)) {
                    return (T) baseEnum;
                }
            }
        }
        return null;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
