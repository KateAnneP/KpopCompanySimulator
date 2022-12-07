package com.example.symulator;

public class Idol {
    private String nick;
    private int wiek;
    private String pozycja;
    private String grupa;

    public Idol(String nick, int wiek, String pozycja, String grupa) {
        this.grupa = grupa;
        this.wiek = wiek;
        this.nick = nick;
        this.pozycja = pozycja;
    }


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPozycja() {
        return pozycja;
    }

    public void setPozycja(String pozycja) {
        this.pozycja = pozycja;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }
}
