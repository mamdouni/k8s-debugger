package org.spring.example.k8s.debugger.actuator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ActuatorEndpointsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void healthCheck_SimpleGet_ReturnAResponse() throws Exception {
        this.mockMvc.perform(get("/actuator/health"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void livenessCheck_SimpleGet_ReturnAResponse() throws Exception {
        this.mockMvc.perform(get("/actuator/health/liveness"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void readinessCheck_SimpleGet_ReturnAResponse() throws Exception {
        this.mockMvc.perform(get("/actuator/health/readiness"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
