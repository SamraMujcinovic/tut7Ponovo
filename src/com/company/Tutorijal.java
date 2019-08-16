package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Tutorijal {


    public static void main(String[] args){

        ArrayList<Grad> gradovi = ucitajGradove();
        UN un = ucitajXml(gradovi);

        System.out.println(un);
    }
    public static ArrayList<Grad> ucitajGradove() {

        Scanner citajIzDatoteke;
        PrintWriter pisiUDatoteku;

        //otvaranje datoteke za citanje
        try {
            citajIzDatoteke = new Scanner(new FileReader("mjerenja.txt"));

        }catch (FileNotFoundException e){
            System.out.println("Datoteka mjerenja.txt nije pronadjena.");
            return null;
        }

        ArrayList<Grad> gradoviIzDatoteke = new ArrayList<>();

        int i = 1;
        while(citajIzDatoteke.hasNext()){
            if(i == 1000) throw new IndexOutOfBoundsException("Prekoracen maksimalan broj gradova");
            i++;
            String red = citajIzDatoteke.nextLine();
            String[] nizRed = new String[1000];
            nizRed = red.split(",");
            if(nizRed.length > 1001) throw new IndexOutOfBoundsException("Previse mjerenja temperature!");
            double[] temperature = new double[1000];
            for(int j = 1; j<nizRed.length;j++){
                temperature[j-1] = Double.parseDouble(nizRed[j]);
            }
            Grad grad = new Grad(nizRed[0], 0, temperature, nizRed.length);
            gradoviIzDatoteke.add(grad);
        }

        return gradoviIzDatoteke;

    }

        public static UN ucitajXml(ArrayList<Grad> gradovi){
            UN drzaveUN = new UN();

            Document dokument = null;

            try {
                DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                dokument = (Document) docBuilder.parse(new File("drzave.xml"));
            } catch (Exception e) {
                System.out.println("Datoteka drzave.xml nije ispravna.");
            }

            Element korijen = dokument.getDocumentElement();

            NodeList drzaveXml = dokument.getElementsByTagName("drzava");

            for(int i = 0; i < drzaveXml.getLength(); i++){
                Node drzavaNode = drzaveXml.item(i);

                if(drzavaNode instanceof Element){
                    Element drzavaEl = (Element) drzavaNode;

                    int brojStanovnika = Integer.parseInt(drzavaEl.getAttribute("stanovnika"));
                    String nazivDrzave = drzavaEl.getElementsByTagName("naziv").item(0).getTextContent();

                    Element grad = (Element) drzavaEl.getElementsByTagName("glavnigrad").item(0);
                    int brStanovnikaGrada = Integer.parseInt(grad.getAttribute("stanovnika"));
                    String nazivGrada = grad.getElementsByTagName("naziv").item(0).getTextContent();

                    Element povrsinaXml = (Element) drzavaEl.getElementsByTagName("povrsina").item(0);
                    String jedinica = povrsinaXml.getAttribute("jedinica");
                    double povrsina = Double.parseDouble(drzavaEl.getElementsByTagName("povrsina").item(0).getTextContent());

                    Grad grad1 = new Grad(nazivGrada, brStanovnikaGrada, null, 0);
                    Drzava drzava1 = new Drzava(nazivDrzave, brojStanovnika, povrsina, jedinica, grad1);
                    drzaveUN.getDrzave().add(drzava1);
                }
            }

            for(Drzava d: drzaveUN.getDrzave()){
                for(Grad g: gradovi){
                    if(d.getGrad().getNaziv().equals(g.getNaziv())){
                        d.getGrad().setTemperature(g.getTemperature());
                    }
                }
            }

            return drzaveUN;
        }

        public static void zapisiXml(UN un){
            try{
                XMLEncoder izlaz = new XMLEncoder(new FileOutputStream("un.xml"));
                izlaz.writeObject(un);

                izlaz.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
}
