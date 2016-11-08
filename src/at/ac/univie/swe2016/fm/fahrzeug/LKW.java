package at.ac.univie.swe2016.fm.fahrzeug;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LKW extends Fahrzeug {

    public LKW(String marke, String modell, int baujahr, double grundpreis, int id) {
        super(marke, modell, baujahr, grundpreis, id);
    }

    @Override
    public double getRabatt() {
        Calendar now  = Calendar.getInstance();
        double rabatt = 5 * (now.get(Calendar.YEAR) - this.getBaujahr());
        return rabatt > 0 ? (rabatt > 20 ? 20 : rabatt) : 0;
    }

    @Override
    public String toString()
    {
        String out = "";
        out += "Typ: LKW\n";
        out += "Id: " + this.getId() + "\n";
        out += "Marke: " + this.getMarke() + "\n";
        out += "Modell: " + this.getModell() + "\n";
        out += "Baujahr: " + this.getBaujahr() + "\n";
        out += "Grundpreis: " + this.getGrundpreis() + "\n";
        out += "Preis: " + this.getPreis() + "\n";

        return out;
    }
}
