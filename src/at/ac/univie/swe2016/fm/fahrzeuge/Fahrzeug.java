package at.ac.univie.swe2016.fm.fahrzeuge;

import java.util.Calendar;

abstract public class Fahrzeug
{
    private String marke;
    private String modell;
    private int baujahr;
    private float grundpreis;
    private int id;

    public Fahrzeug() {}

    public Fahrzeug(String marke, String modell, int baujahr, float grundpreis, int id) {
        this.setMarke(marke);
        this.setBaujahr(baujahr);
        this.setModell(modell);
        this.setGrundpreis(grundpreis);
        this.setId(id);
    }

    abstract public float getRabatt();

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

    public float getGrundpreis() {
        return grundpreis;
    }

    public void setGrundpreis(float grundpreis) {
        this.grundpreis = grundpreis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlter()
    {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) - this.getBaujahr();
    }

    public float getPreis()
    {
        return (this.getGrundpreis() * this.getRabatt()) / 100;
    }

    public String toString()
    {
        return "Fahrzeug dump";
    }

}
