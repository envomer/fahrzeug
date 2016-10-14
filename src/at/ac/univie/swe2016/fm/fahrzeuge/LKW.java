package at.ac.univie.swe2016.fm.fahrzeuge;

import java.util.Calendar;

public class LKW extends Fahrzeug {

    @Override
    public float getRabatt() {
        Calendar now  = Calendar.getInstance();
        float rabatt = 5 * (now.get(Calendar.YEAR) - this.getBaujahr());
        return rabatt > 0 ? rabatt : 0;
    }
}
