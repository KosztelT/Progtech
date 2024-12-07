package org.example;

import org.example.controller.HallgatoController;
import org.example.service.NeptunRendszer;
import org.example.model.Hallgato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HallgatoControllerTest {

    @MockBean
    private NeptunRendszer neptunRendszer;

    @InjectMocks
    private HallgatoController hallgatoController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(hallgatoController).build();
    }

    @Test
    void testUjHallgatoApi() throws Exception {
        // Mockeld a NeptunRendszer szolgáltatás metódusát
        doNothing().when(neptunRendszer).ujHallgato(anyString(), anyString());

        // POST kérés küldése az új hallgató hozzáadásához
        mockMvc.perform(post("/ujHallgato")
                        .param("nev", "Kovács János")
                        .param("neptunKod", "ABC123"))
                .andExpect(status().is3xxRedirection()) // HTTP 3xx kód, ami átirányítást jelent
                .andExpect(header().string("Location", "/")); // Ellenőrizd, hogy a Location header a főoldalra mutat
    }
}