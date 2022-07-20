package com.example.jsonschemal.jsongenerator.enity;

import com.example.jsonschemal.jsongenerator.annotation.JsonSchemaProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Collections;
import java.util.List;


@Data
@JsonSchemaProperty(title = "测试")
// 使用该注解需要配置jackSonModule Jackson.RESPECT_JSONPROPERTY_ORDER
@JsonPropertyOrder({
        "dataEnName",
        "condition",
        "requiredItems",
        "sortItems",
        "fullTextSearchKeys",
        "pageNum",
        "pageSize"
})
public class JsonSchemaEnity {
    @JsonSchemaProperty(title = "jsonschema测试实体标题")
    @NotNull(message = "使用该注解还需要加入雅加达option")
    private String dataEnName;

    @JsonSchemaProperty(title = "页码")
    private Integer pageNum;

    @JsonSchemaProperty(title = "每页条数")
    private Integer pageSize;

    @JsonSchemaProperty(title = "字段范围")
    private List<String> requiredItems = Collections.emptyList();

    @JsonSchemaProperty(title = "排序字段")
    private List<String> sortItems = Collections.emptyList();

    @JsonSchemaProperty(title = "全文检索关键词")
    private List<String> fullTextSearchKeys = Collections.emptyList();

    @JsonSchemaProperty(
            title = "查询条件",
            oneOf = {
                    ConditionNormalExpressionTempDTO.LogicExpression.class,
                    ConditionNormalExpressionTempDTO.OperationExpression.class
            }
    )
    private ConditionNormalExpressionTempDTO condition;

}
