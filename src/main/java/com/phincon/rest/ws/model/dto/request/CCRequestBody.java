package com.phincon.rest.ws.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CCRequestBody {

    @NotBlank(message = "cust is required")
    private String cust;
}
