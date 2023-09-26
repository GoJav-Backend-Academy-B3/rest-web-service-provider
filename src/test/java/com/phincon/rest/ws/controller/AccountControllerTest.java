package com.phincon.rest.ws.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.hamcrest.Matchers.hasKey;


@WebMvcTest(AccountController.class)
public class AccountControllerTest {


    @Autowired
    private AccountController accountController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("When request GET inquiryAccount should return correct response")
    void whenGetRequestInquiryAccount_thenReturnCorrectResponse() throws Exception{
        String cifnbr = "0001062020";

        mockMvc.perform(MockMvcRequestBuilders.get("/web/services/INQACCT/INQACCT/{cifnbr}", cifnbr))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasKey("COUNT")))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasKey("RESP")))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasKey("DATARAW")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.DATARAW").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.DATARAW[0]").value(hasKey("ACCOUNTNBR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.DATARAW[0]").value(hasKey("PRODUCTNAME")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.DATARAW[0]").value(hasKey("PRODUCTTP")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.DATARAW[0]").value(hasKey("CURR")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.DATARAW[0]").value(hasKey("PRIMARY")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.DATARAW[0]").value(hasKey("ACCTSTAT")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.DATARAW[0]").value(hasKey("ATMCARD")));
    }

}
