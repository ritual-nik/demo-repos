package com.poc.exception_handling.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private UUID id;

    private String name;
}
