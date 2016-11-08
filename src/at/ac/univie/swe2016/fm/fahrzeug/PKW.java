package at.ac.univie.swe2016.fm.fahrzeug;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PKW extends Fahrzeug
{
    private Calendar letzteUeberpruefung;

    public PKW(String marke, String modell, int baujahr, double grundpreis, int id) {
        super(marke, modell, baujahr, grundpreis, id);
    }

    public Calendar getLetzteUeberpruefung() {
        return letzteUeberpruefung;
    }

    public void setLetzteUeberpruefung(Calendar ueberpruefung) {
        this.letzteUeberpruefung = ueberpruefung;
    }

    public void setLetzteUeberpruefung() {
        Calendar now = Calendar.getInstance();
        this.letzteUeberpruefung = now;
    }

    @Override
    public double getRabatt() {
        Calendar now  = Calendar.getInstance();
        double rabatt = 5 * (now.get(Calendar.YEAR) - this.getBaujahr()) + (2 * this.getLetzteUeberpruefung().get(Calendar.YEAR));
        return rabatt > 0 ? (rabatt > 15 ? 15 : rabatt) : 0;
    }

    @Override
    public String toString()
    {
        String out = "";
        String ueperpruefung = new SimpleDateFormat("yyyy-MM-dd").format(this.getLetzteUeberpruefung().getTime());
        out += "Typ: PKW\n";
        out += "Id: " + this.getId() + "\n";
        out += "Marke: " + this.getMarke() + "\n";
        out += "Modell: " + this.getModell() + "\n";
        out += "Baujahr: " + this.getBaujahr() + "\n";
        out += "Grundpreis: " + this.getGrundpreis() + "\n";
        out += "Überprüfungsdatum: " + ueperpruefung + "\n";
        out += "Preis: " + this.getPreis() + "\n";

        return out;
    }
}
