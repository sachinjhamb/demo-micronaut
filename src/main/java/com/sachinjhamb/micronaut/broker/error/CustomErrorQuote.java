package com.sachinjhamb.micronaut.broker.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorQuote {
    private int status;
    private String error;
    private String message;
    private String path;
}
