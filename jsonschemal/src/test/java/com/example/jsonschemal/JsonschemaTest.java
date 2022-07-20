package com.example.jsonschemal;

import com.example.jsonschemal.jsongenerator.enity.JsonSchemaEnity;
import com.example.jsonschemal.jsongenerator.generator.JsonSchemaGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

public class JsonschemaTest {
    @Test
    public void test(){
        JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator();
        final JsonSchemaGenerator build = jsonSchemaGenerator.builder().build();
        final JsonNode node = build.generate(JsonSchemaEnity.class);
        final JsonNode schema = node.get("Schema");
        final JsonNode uiSchema = node.get("uiSchema");

        System.out.printf(schema.toString());
        System.out.println();

    }



}
