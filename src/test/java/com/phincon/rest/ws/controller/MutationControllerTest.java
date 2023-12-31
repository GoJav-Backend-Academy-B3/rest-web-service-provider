package com.phincon.rest.ws.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.hamcrest.Matchers.hasKey;

@WebMvcTest(MutationController.class)
public class MutationControllerTest {


    @Autowired
    private MutationController mutationController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("when requesting Get AccHistory then return correct response")
    void whenGetRequestAccHistory_thenReturnCorrectResponse() throws Exception{
        String ACCTNBR ="1002521739";
        String ACCTPP = "20";
        String STRDATE ="01092023";
        String ENDDATE ="18092023";
        String STRINDEX ="0";

        mockMvc.perform(MockMvcRequestBuilders.get("/web/services/ACCTHST/ACCTHST/{ACCTNBR}/{ACCTPP}/{STRDATE}/{ENDDATE}/{STRINDEX}",
                ACCTNBR, ACCTPP, STRDATE, ENDDATE, STRINDEX))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasKey("RESP")))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasKey("MOREDTA")))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasKey("LASTINDEX")))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasKey("MUTASI")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("TRXDATE")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("PSTGDATE")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("TRXCODE")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("TRXCODEDSC")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("DESCRIPTION")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("CURR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("TRXAMOUNT")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("LCLCCY")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("LCLEQUIVAL")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("DBCR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("BUYEXCH")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("SELLEXCH")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("REFERENSI")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("CHKBGNBR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("RUNBAL")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.MUTASI[0]").value(hasKey("EFEKTIF")));


    }
}
