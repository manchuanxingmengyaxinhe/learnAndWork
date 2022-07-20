package com.example.jsonschemal.jsongenerator.enity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.example.jsonschemal.jsongenerator.annotation.JsonSchemaProperty;
import lombok.*;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 数据服务条件字段普通模式表达式实体
 *
 * @author zhu.kaize
 * @version 1.0
 */
public abstract class ConditionNormalExpressionTempDTO implements Serializable {

  private static final long serialVersionUID = 6651969181281643759L;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @JsonSchemaProperty(title = "操作表达式")
  public static class OperationExpression extends ConditionNormalExpressionTempDTO {
    private static final long serialVersionUID = -7222877864256499280L;

    @JsonSchemaProperty(title = "字段信息")
    private Field field;

    @JSONField(deserializeUsing = StringEnumDeserializer.class)
    @JsonSchemaProperty(title = "操作符")
    private Operator operator;

    @JsonSchemaProperty(title = "值")
    private List<String> value;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @JsonSchemaProperty(title = "逻辑表达式")
  public static class LogicExpression extends ConditionNormalExpressionTempDTO {
    private static final long serialVersionUID = 2590804186521066306L;

    @JSONField(deserializeUsing = StringEnumDeserializer.class)
    @JsonSchemaProperty(title = "表达式测试")
    private LogicExpressionEnum expression;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @JsonSchemaProperty(title = "逻辑表达式")
  public static class oneOfExpression extends ConditionNormalExpressionTempDTO {
    private static final long serialVersionUID = 2590804186521066306L;

    @JSONField(deserializeUsing = StringEnumDeserializer.class)
    @JsonSchemaProperty(title = "表达式")
    private LogicExpressionEnum expression;
  }



  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Field implements Serializable {

    private static final long serialVersionUID = 3567616732851539880L;

    private String code;

    private String enName;

    private String cnName;

    private String dataType;
  }

  @Getter
  @AllArgsConstructor
  @JSONType(deserializer = StringEnumDeserializer.class, serializeEnumAsJavaBean = true)
  enum Operator implements GenericBaseEnum<String> {
    EQUAL("=", "等于"),
    NOT_EQUAL("<>", "不等于"),
    GREATER_THAN(">=", "大于等于"),
    GREATER_EITHER(">", "大于"),
    LESS_THAN("<=", "小于等于"),
    LESS_EITHER("<", "小于"),
    IN("in", "包含"),
    NOT_IN("not in", "不包含"),
    LIKE("like", "匹配（模糊）"),
    NOT_LIKE("not like", "不匹配（模糊）"),
    IS_NULL("is null", "为空"),
    IS_NOT_NULL("is not null", "不为空"),
    ;

    private final String code;

    private final String text;
  }

  @Getter
  @AllArgsConstructor
  @JSONType(deserializer = StringEnumDeserializer.class, serializeEnumAsJavaBean = true)
  enum LogicExpressionEnum implements GenericBaseEnum<String> {
    AND("and", "且"),
    OR("or", "或"),
    NOT("not", "非"),
    LEFT_PARENTHESIS("(", "左括号"),
    RIGHT_PARENTHESIS(")", "右括号"),
    ;

    private final String code;

    private final String text;
  }

}
