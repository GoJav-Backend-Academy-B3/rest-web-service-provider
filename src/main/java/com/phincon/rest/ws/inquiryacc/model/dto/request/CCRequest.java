package com.phincon.rest.ws.inquiryacc.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CCRequest {
    @Valid
    @NotNull(message = "rqHeader is required")
    private CCRequestHeader rqHeader;

    @Valid
    @NotNull(message = "rqBody is required")
    private CCRequestBody rqBody;
}
