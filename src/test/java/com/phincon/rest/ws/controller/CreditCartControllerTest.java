package com.phincon.rest.ws.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.phincon.rest.ws.model.dto.request.CCRequest;
import com.phincon.rest.ws.model.dto.request.CCRequestBody;
import com.phincon.rest.ws.model.dto.request.CCRequestHeader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



import static org.hamcrest.Matchers.hasKey;


@WebMvcTest(CreditCartController.class)
public class CreditCartControllerTest {


    @Autowired
    private CreditCartController creditCartController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("when credit cart request then should response 200")
    void whenRequestCartNumber_thenReturnCorrectResponse() throws Exception{
        CCRequestHeader rqHeader = new CCRequestHeader("listCustomerCIFCardSummaryListInput", "ABCDEFHIJKLMNOPQRSTUVWXY7","CC","2023-09-19 15:48:57.821", "");
        CCRequestBody rqBody = new CCRequestBody("4377014000235208");
        CCRequest request = new CCRequest(rqHeader, rqBody);

        mockMvc.perform(MockMvcRequestBuilders.post("/web/services/creditcard")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasKey("rsHeader")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader").value(hasKey("rqHeader")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader.rqHeader").value(hasKey("service")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader.rqHeader").value(hasKey("traceID")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader.rqHeader").value(hasKey("channel")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader.rqHeader").value(hasKey("timestamp")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader.rqHeader").value(hasKey("listKey")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader").value(hasKey("timeStamp")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader").value(hasKey("status")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader").value(hasKey("statusDesc")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader").value(hasKey("listCount")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader").value(hasKey("listCount")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsHeader").value(hasKey("listKey")))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(hasKey("rsBody")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardNbr")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardPrd")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardPrdCurr")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardPrdType")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardAplType")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardSts")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardBlk")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardInactiveDt")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardCrLimit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardCrLimit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rsBody[0]").value(hasKey("cardAcPyDueDt")));
    }

    @Test
    @DisplayName("when request with bad payload then should resposne 400")
    void whenRequestWithBadPayload_thenReturnCorrectResponse() throws  Exception{
        CCRequestHeader rqHeader = new CCRequestHeader(null, null,null,null, "");
        CCRequestBody rqBody = new CCRequestBody("4377014000235208");
        CCRequest request = new CCRequest(rqHeader, rqBody);
        String message = "is required";

        mockMvc.perform(MockMvcRequestBuilders.post("/web/services/creditcard")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.['rqHeader.channel']").value("channel "+message))
                .andExpect(MockMvcResultMatchers.jsonPath("$.['rqHeader.service']").value("service "+message))
                .andExpect(MockMvcResultMatchers.jsonPath("$.['rqHeader.traceID']").value("traceID "+message))
                .andExpect(MockMvcResultMatchers.jsonPath("$.['rqHeader.timestamp']").value("timestamp "+message));




    }
}
