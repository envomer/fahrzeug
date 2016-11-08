package at.ac.univie.swe2016.fm;

import at.ac.univie.swe2016.fm.fahrzeug.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeug.LKW;
import at.ac.univie.swe2016.fm.fahrzeug.PKW;
import swe2016.fm.fahrzeuge.dao.FahrzeugDAO;
import swe2016.fm.fahrzeuge.dao.SerializedFahrzeugDAO;

import java.util.ArrayList;

public class FahrzeugManagement
{
    private FahrzeugDAO fahrzeugDAO;

    public FahrzeugManagement() {
        this.fahrzeugDAO = new SerializedFahrzeugDAO("/Users/envomer/Downloads/fahrzeuge.ext");
    }

    public void addFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeugDAO.speichereFahrzeug(fahrzeug);
    }

    public void removeFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeugDAO.loescheFahrzeug(fahrzeug);
    }

    public int countFahrzeuge() {
        ArrayList<Fahrzeug> fahrzeuge = this.fahrzeugDAO.getFahrzeugList();
        return fahrzeuge.size();
    }

    public int countPKW() {
        ArrayList<Fahrzeug> fahrzeuge = this.fahrzeugDAO.getFahrzeugList();
        int count = 0;
        for(Fahrzeug fahrzeug: fahrzeuge) {
            if( fahrzeug instanceof PKW) {
                count++;
            }
        }
        return count;
    }

    public int countLKW() {
        ArrayList<Fahrzeug> fahrzeuge = this.fahrzeugDAO.getFahrzeugList();
        int count = 0;
        for(Fahrzeug fahrzeug: fahrzeuge) {
            if( fahrzeug instanceof LKW) {
                count++;
            }
        }
        return count;
    }
}
