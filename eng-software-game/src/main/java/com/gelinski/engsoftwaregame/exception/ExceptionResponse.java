package com.gelinski.engsoftwaregame.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
    private Date timestamp;
    private String message;
    private String details;
}
