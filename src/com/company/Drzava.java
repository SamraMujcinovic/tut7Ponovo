package com.company;

public class Drzava {
    private String naziv;
    private int brojStanovnika;
    private double povrsina;
    private String jedinicaZaPovrsinu;
    private Grad grad;

    public Drzava(){
        naziv = "";
        brojStanovnika = 0;
        povrsina = 0;
        jedinicaZaPovrsinu = "";
        grad = null;
    }

    public Drzava(String naziv, int brojStanovnika, double povrsina, String jedinicaZaPovrsinu, Grad grad) {
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
        this.povrsina = povrsina;
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
        this.grad = grad;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public String getJedinicaZaPovrsinu() {
        return jedinicaZaPovrsinu;
    }

    public void setJedinicaZaPovrsinu(String jedinicaZaPovrsinu) {
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        String s = "" + naziv + " ima " + brojStanovnika + " povrsine: " + povrsina + " " + jedinicaZaPovrsinu + ", glavni grad je " + grad.getNaziv();
        return s;
    }
}
