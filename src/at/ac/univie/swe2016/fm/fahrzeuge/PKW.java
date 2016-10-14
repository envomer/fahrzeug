package at.ac.univie.swe2016.fm.fahrzeuge;

import java.util.Calendar;

public class PKW extends Fahrzeug
{
    private Calendar letzteUeberpruefung;

    public Calendar getLetzteUeberpruefung() {
        return letzteUeberpruefung;
    }

    @Override
    public float getRabatt() {
        Calendar now  = Calendar.getInstance();
        float rabatt = 5 * (now.get(Calendar.YEAR) - this.getBaujahr()) + (2 * this.getLetzteUeberpruefung().get(Calendar.YEAR));
        return rabatt > 0 ? rabatt : 0;
    }
}
