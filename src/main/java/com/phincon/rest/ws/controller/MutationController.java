package com.phincon.rest.ws.controller;


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
@RequestMapping("/web/services/ACCTHST")
public class MutationController {

    public final String MUTATION_RESPONSE = "src/main/resources/specification/Mutasi_response.json";

    @GetMapping("/ACCTHST/{ACCTNBR}/{ACCTPP}/{STRDATE}/{ENDDATE}/{STRINDEX}")
    public ResponseEntity<Map<String, Object>> accHistory(
            @PathVariable(value = "ACCTNBR") String acctNBR,
            @PathVariable(value = "ACCTPP") String acctPP,
            @PathVariable(value = "STRDATE") String strDATE,
            @PathVariable(value = "ENDDATE") String endDATE,
            @PathVariable(value = "STRINDEX") String strINDEX
    ) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mutations = mapper.readValue(new File(MUTATION_RESPONSE), new TypeReference<Map<String, Object>>() {});
        return new ResponseEntity<>(mutations, HttpStatus.OK);
    }
}
