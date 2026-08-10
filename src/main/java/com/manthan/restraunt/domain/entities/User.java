package com.manthan.restraunt.domain.entities;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Field(type =  FieldType.Keyword)
    private String id;

    @Field(type =  FieldType.Text)
    private String username;

    @Field(type =  FieldType.Text)
    private String givenName;
    
    @Field(type =  FieldType.Text)
    private String familyName;
}
