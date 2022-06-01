package com.example.CRUDSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    private static final long serialVersionId=1L;

    public ResourceNotFound(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with field name %s:%s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }



}
