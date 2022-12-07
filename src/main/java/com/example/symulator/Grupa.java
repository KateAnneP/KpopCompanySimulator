package com.example.symulator;

import java.util.Random;
public class Grupa {
    private String nazwa;
    private int hp;
    private int dni_od_comebacku;
    private int liczba_fanow;
    private int ilosc_piosenek;
    private int kontrakt;


    public Grupa(String nazwa) {
        this.nazwa = nazwa;
        this.hp = 1000;
        this.dni_od_comebacku = 1;
        Random losowa = new Random();
        this.liczba_fanow = losowa.nextInt(101);
        this.ilosc_piosenek = 1;
        this.kontrakt = 1826;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDni_od_comebacku() {
        return dni_od_comebacku;
    }

    public void setDni_od_comebacku(int dni_od_comebacku) {
        this.dni_od_comebacku = dni_od_comebacku;
    }

    public int getLiczba_fanow() {
        return liczba_fanow;
    }

    public void setLiczba_fanow(int liczba_fanow) {
        this.liczba_fanow = liczba_fanow;
    }

    public int getIlosc_piosenek() {
        return ilosc_piosenek;
    }

    public void setIlosc_piosenek(int ilosc_piosenek) {
        this.ilosc_piosenek = ilosc_piosenek;
    }

    public int getKontrakt() {
        return kontrakt;
    }

    public void setKontrakt(int kontrakt) {
        this.kontrakt = kontrakt;
    }
}
