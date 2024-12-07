package com.neptun.neptun_web.model;

import java.util.ArrayList;
import java.util.List;

public class Kurzus {
    private String kurzusKod;
    private String nev;
    private List<Hallgato> hallgatok;

    public Kurzus(String kurzusKod, String nev) {
        this.kurzusKod = kurzusKod;
        this.nev = nev;
        this.hallgatok = new ArrayList<>();
    }

    public String getKurzusKod() {
        return kurzusKod;
    }

    public String getNev() {
        return nev;
    }

    public List<Hallgato> getHallgatok() {
        return hallgatok;
    }

    public void hozzaadHallgato(Hallgato hallgato) {
        hallgatok.add(hallgato);
    }

    @Override
    public String toString() {
        return "Kurzus-kód: " + kurzusKod + ", Név: " + nev + ", Hallgatók száma: " + hallgatok.size();
    }
}
