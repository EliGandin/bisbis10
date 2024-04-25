package com.att.tdp.bisbis10.converters;

import com.att.tdp.bisbis10.entities.Dish;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Converter
public class MapToJsonConverter implements AttributeConverter<Map<Dish, Integer>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<Dish, Integer> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public Map<Dish, Integer> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, HashMap.class);
        } catch (IOException e) {
            return null;
        }
    }
}
