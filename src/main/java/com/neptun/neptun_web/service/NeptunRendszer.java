package com.neptun.neptun_web.service;

import com.neptun.neptun_web.model.Hallgato;
import com.neptun.neptun_web.model.Kurzus;

import java.util.ArrayList;
import java.util.List;

public class NeptunRendszer {
    private List<Hallgato> hallgatok;
    private List<Kurzus> kurzusok;

    public NeptunRendszer() {
        this.hallgatok = new ArrayList<>();
        this.kurzusok = new ArrayList<>();
    }

    // Új hallgató hozzáadása
    public void ujHallgato(String neptunKod, String nev) {
        hallgatok.add(new Hallgato(neptunKod, nev));
    }

    // Új kurzus hozzáadása
    public void ujKurzus(String kurzusKod, String nev) {
        kurzusok.add(new Kurzus(kurzusKod, nev));
    }

    // Hallgató hozzárendelése kurzushoz
    public void hozzarendelHallgatotKurzushoz(String neptunKod, String kurzusKod) {
        Hallgato hallgato = hallgatok.stream()
                .filter(h -> h.getNeptunKod().equals(neptunKod))
                .findFirst()
                .orElse(null);

        Kurzus kurzus = kurzusok.stream()
                .filter(k -> k.getKurzusKod().equals(kurzusKod))
                .findFirst()
                .orElse(null);

        if (hallgato != null && kurzus != null) {
            kurzus.hozzaadHallgato(hallgato);
        } else {
            System.out.println("Nem található hallgató vagy kurzus!");
        }
    }

    // Az összes hallgató listázása
    public void listazHallgatok() {
        hallgatok.forEach(System.out::println);
    }

    // Az összes kurzus listázása
    public void listazKurzusok() {
        kurzusok.forEach(System.out::println);
    }

    // Minden hallgató lekérése
    public List<Hallgato> getHallgatok() {
        return hallgatok;
    }

    // Hallgató keresése Neptun kód alapján
    public Hallgato keresHallgato(String neptunKod) {
        return hallgatok.stream()
                .filter(h -> h.getNeptunKod().equals(neptunKod))
                .findFirst()
                .orElse(null);
    }
}
