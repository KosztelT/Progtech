package com.neptun.neptun_web.model;

import java.util.ArrayList;
import java.util.List;

public class Hallgato {
    private String neptunKod;
    private String nev;
    private List<Kurzus> kurzusok; // Listázza a hallgatóhoz rendelt kurzusokat

    public Hallgato(String neptunKod, String nev) {
        this.neptunKod = neptunKod;
        this.nev = nev;
        this.kurzusok = new ArrayList<>(); // Inicializálás
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public String getNev() {
        return nev;
    }

    // Új kurzus hozzáadása a hallgatóhoz
    public void addKurzus(Kurzus kurzus) {
        this.kurzusok.add(kurzus);
    }

    // Kurzusok lekérése
    public List<Kurzus> getKurzusok() {
        return kurzusok;
    }

    @Override
    public String toString() {
        return "Neptun-kód: " + neptunKod + ", Név: " + nev;
    }
}
