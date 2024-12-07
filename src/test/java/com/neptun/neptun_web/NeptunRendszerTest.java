package com.neptun.neptun_web;

import com.neptun.neptun_web.model.Hallgato;
import com.neptun.neptun_web.model.Kurzus;
import com.neptun.neptun_web.service.NeptunRendszer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeptunRendszerTest {

    private NeptunRendszer neptunRendszer;

    @BeforeEach
    void setUp() {
        neptunRendszer = new NeptunRendszer();
    }

    @Test
    void ujHallgatoTeszt() {
        neptunRendszer.ujHallgato("ABC123", "Kovács János");

        Hallgato hallgato = neptunRendszer.keresHallgato("ABC123");
        assertNotNull(hallgato);
        assertEquals("ABC123", hallgato.getNeptunKod());
        assertEquals("Kovács János", hallgato.getNev());
    }

    @Test
    void listazHallgatokTeszt() {
        neptunRendszer.ujHallgato("ABC123", "Kovács János");
        neptunRendszer.ujHallgato("DEF456", "Nagy Péter");

        neptunRendszer.listazHallgatok();

        assertEquals(2, neptunRendszer.getHallgatok().size());
    }


    @Test
    void keresHallgatoTeszt() {
        neptunRendszer.ujHallgato("ABC123", "Kovács János");

        Hallgato hallgato = neptunRendszer.keresHallgato("ABC123");

        assertNotNull(hallgato);
        assertEquals("ABC123", hallgato.getNeptunKod());
        assertEquals("Kovács János", hallgato.getNev());
    }

    @Test
    void nemTalalHibasHallgatoTeszt() {
        Hallgato hallgato = neptunRendszer.keresHallgato("XYZ999");
        assertNull(hallgato);
    }
}