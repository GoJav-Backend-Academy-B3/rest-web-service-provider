package com.phincon.rest.ws.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phincon.rest.ws.model.dto.request.CCRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/web/services/creditcard")
public class CreditCartController {

    public final String CREDIT_CARD_RESPONSE = "src/main/resources/specification/CreditCard_cardnumber_response.json";

    @PostMapping
    public ResponseEntity<Map<String, Object>> creditCard(@Valid @RequestBody CCRequest request) throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> response = mapper.readValue(new File(CREDIT_CARD_RESPONSE), new TypeReference<Map<String, Object>>() {});
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
