package com.poc.exception_handling.model;

import com.poc.exception_handling.validation.NameValidationConstraint;
import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private UUID id;

    @NameValidationConstraint
    private String name;
}
