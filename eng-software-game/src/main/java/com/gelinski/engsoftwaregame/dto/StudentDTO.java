package com.gelinski.engsoftwaregame.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
public class StudentDTO implements Serializable {
    private Long id;
    private String name;
    private Long group;
}