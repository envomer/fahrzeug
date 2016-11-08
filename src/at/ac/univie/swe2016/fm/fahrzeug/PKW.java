package at.ac.univie.swe2016.fm.fahrzeug;

import java.util.Calendar;

public class PKW extends Fahrzeug
{
    private Calendar letzteUeberpruefung;

    public Calendar getLetzteUeberpruefung() {
        return letzteUeberpruefung;
    }

    public PKW(String marke, String modell, int baujahr, double grundpreis, int id) {
        super(marke, modell, baujahr, grundpreis, id);
    }

    @Override
    public double getRabatt() {
        Calendar now  = Calendar.getInstance();
        double rabatt = 5 * (now.get(Calendar.YEAR) - this.getBaujahr()) + (2 * this.getLetzteUeberpruefung().get(Calendar.YEAR));
        return rabatt > 0 ? (rabatt > 15 ? 15 : rabatt) : 0;
    }
}
