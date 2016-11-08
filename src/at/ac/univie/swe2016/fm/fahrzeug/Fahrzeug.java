package at.ac.univie.swe2016.fm.fahrzeug;

import java.io.Serializable;
import java.util.Calendar;

abstract public class Fahrzeug implements Serializable
{
    private String marke;
    private String modell;
    private int baujahr;
    private double grundpreis;
    private int id;

    public Fahrzeug() {}

    public Fahrzeug(String marke, String modell, int baujahr, double grundpreis, int id) {
        this.setMarke(marke);
        this.setBaujahr(baujahr);
        this.setModell(modell);
        this.setGrundpreis(grundpreis);
        this.setId(id);
    }

    abstract public double getRabatt();

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        Calendar now = Calendar.getInstance();
        if( baujahr >  now.get(Calendar.YEAR) ) {
            throw new IllegalArgumentException("Baujahr kann nicht größer als dieses Jahr sein");
        }
        this.baujahr = baujahr;
    }

    public double getGrundpreis() {
        return grundpreis;
    }

    public void setGrundpreis(double grundpreis) {
        this.grundpreis = grundpreis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlter() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) - this.getBaujahr();
    }

    public double getPreis() {
        return (this.getGrundpreis() * this.getRabatt()) / 100;
    }

    public String toString() {
        return "Fahrzeug dump";
    }

}
