package com.polatavci.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse<T> {

    private boolean success = false;

    private T message;

    private int status;

    private LocalDateTime timestamp;
}
