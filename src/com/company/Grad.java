package com.company;

public class Grad {
        private String naziv;
        private int brojStanovnika;
        private double[] temperature;
        private int brojTemperatura = 0;

        public Grad(){
            naziv = "";
            brojStanovnika = 0;
            temperature = new double[1000];
        }

        public Grad(String naziv, int brojStanovnika, double[] temperature,int brojTemperatura) {
            this.naziv = naziv;
            this.brojStanovnika = brojStanovnika;
            this.temperature = temperature;
            this.brojTemperatura = brojTemperatura;
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

        public double[] getTemperature() {
            return temperature;
        }

        public void setTemperature(double[] temperature) {
            this.temperature = temperature;
        }
}
