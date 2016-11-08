package at.ac.univie.swe2016.fm.fahrzeug;

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
}
