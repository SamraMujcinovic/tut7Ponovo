package com.company;

import java.util.ArrayList;

public class UN {
    private ArrayList<Drzava> drzave;

    public UN(){
        drzave = new ArrayList<>();
    }

    public UN(ArrayList<Drzava> d){
        drzave = d;
    }

    public ArrayList<Drzava> getDrzave() {
        return drzave;
    }

    public void setDrzave(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }

    @Override
    public String toString() {
        String s = "";
        for(Drzava d:drzave){
            s+= d + "\n";
        }
        return s;
    }
}
