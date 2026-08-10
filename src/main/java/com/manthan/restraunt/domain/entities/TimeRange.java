package com.manthan.restraunt.domain.entities;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TimeRange {
    
    @Field(type = FieldType.Keyword)
    private String openTime;

    @Field(type = FieldType.Keyword)
    private String closeTime;
}
