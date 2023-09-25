package com.phincon.rest.ws.inquiryacc.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Map;


@RestController
@RequestMapping("/web/services/INQACCT")
public class AccountController {

    public final String INQUIRY_ACC_RESPONSE = "src/main/resources/specification/InquiryAccount_response.json";

    @GetMapping("/INQACCT/{cifnbr}")
    public ResponseEntity<Map<String,Object>> inquiryAccount(@PathVariable(value = "cifnbr") String cifNumber) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> inquiryAccountResponse = mapper.readValue(new File(INQUIRY_ACC_RESPONSE), new TypeReference<Map<String, Object>>() {});
        return new ResponseEntity<>(inquiryAccountResponse, HttpStatus.OK);

    }
}
