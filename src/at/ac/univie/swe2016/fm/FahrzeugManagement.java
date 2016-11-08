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
        this.fahrzeugDAO = new SerializedFahrzeugDAO("/Users/envomer/Downloads/fahrzeuge.txt");
    }

    public void addFahrzeug(Fahrzeug fahrzeug) {
        int count = this.fahrzeugDAO.getFahrzeugList().size();
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

    public double averageFahrzeugPreis() {
        ArrayList<Fahrzeug> fahrzeuge = this.fahrzeugDAO.getFahrzeugList();
        double sum = 0.0;
        for(Fahrzeug fahrzeug: fahrzeuge) {
            sum += fahrzeug.getPreis();
        }
        return sum/fahrzeuge.size();
    }

    public double averagePKWPreis() {
        ArrayList<Fahrzeug> fahrzeuge = this.fahrzeugDAO.getFahrzeugList();
        double sum = 0.0;
        int total = 0;
        for(Fahrzeug fahrzeug: fahrzeuge) {
            if( ! (fahrzeug instanceof PKW) ) continue;
            sum += fahrzeug.getPreis();
            total += 0;
        }
        return sum/total;
    }

    public double averageLKWPreis() {
        ArrayList<Fahrzeug> fahrzeuge = this.fahrzeugDAO.getFahrzeugList();
        double sum = 0.0;
        int count = 0;
        for(Fahrzeug fahrzeug: fahrzeuge) {
            if( ! (fahrzeug instanceof LKW) ) continue;
            sum += fahrzeug.getPreis();
            count += 0;
        }
        return sum/count;
    }

    public double averageFahrzeugAlter()
    {
        ArrayList<Fahrzeug> fahrzeuge = this.fahrzeugDAO.getFahrzeugList();
        double totalAlter = 0.0;
        for(Fahrzeug fahrzeug: fahrzeuge) {
            if( ! (fahrzeug instanceof LKW) ) continue;
            totalAlter += fahrzeug.getAlter();
        }
        return totalAlter/fahrzeuge.size();
    }

    public Fahrzeug oldestFahrzeug()
    {
        ArrayList<Fahrzeug> fahrzeuge = this.fahrzeugDAO.getFahrzeugList();
        Fahrzeug fahrzeug2 = null;
        int alter = 0;
        for(Fahrzeug fahrzeug: fahrzeuge) {
            if( alter < fahrzeug.getAlter() ) {
                alter = fahrzeug.getAlter();
                fahrzeug2 = fahrzeug;
            }
        }
        return fahrzeug2;
    }
}
