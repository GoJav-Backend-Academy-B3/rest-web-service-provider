package com.phincon.rest.ws.inquiryacc.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CCRequestHeader {

    @NotBlank(message = "service is required")
    private String service;

    @NotBlank(message = "traceID is required")
    private String traceID;

    @NotBlank(message = "channel is required")
    private String channel;

    @NotBlank(message = "timestamp is required")
    private String timestamp;

    private String listKey;
}
