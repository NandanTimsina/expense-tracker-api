package com.Project.Project11.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    String ResourceName;
    String FieldName;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resourceName, String fieldName) {
        super(String.format("%s not found with %s",resourceName,fieldName));
        ResourceName = resourceName;
        FieldName = fieldName;
    }

    public ResourceNotFoundException(String resourceName) {
        super(String.format("No %s found ",resourceName));
        ResourceName = resourceName;
    }
}
