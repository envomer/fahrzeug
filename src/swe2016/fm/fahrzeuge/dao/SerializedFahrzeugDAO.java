package swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeug.Fahrzeug;

import java.io.*;
import java.util.ArrayList;

public class SerializedFahrzeugDAO implements FahrzeugDAO
{
    public String pfad = null;

    public SerializedFahrzeugDAO(String pfad) {
        this.pfad = pfad;
    }

    @Override
    public ArrayList getFahrzeugList() {
        ArrayList<Fahrzeug> fahrzeuge = new ArrayList<Fahrzeug>();
        try {
            FileInputStream fis = new FileInputStream(this.pfad);
            ObjectInputStream ois = new ObjectInputStream(fis);
            fahrzeuge = (ArrayList<Fahrzeug>) ois.readObject();
            ois.close();
        }
        catch(Exception e) {
            // e.printStackTrace();
        }

        return fahrzeuge;
    }

    @Override
    public Fahrzeug getFahrzeugbyId(int id) {
        ArrayList<Fahrzeug> fahrzeuge = this.getFahrzeugList();
        for(Fahrzeug fahrzeug: fahrzeuge) {
            if( fahrzeug.getId() == id ) {
                return fahrzeug;
            }
        }
        return null;
    }

    @Override
    public void speichereFahrzeug(Fahrzeug fahrzeug) {
        ArrayList<Fahrzeug> farzeuge = this.getFahrzeugList();
        farzeuge.add(fahrzeug);
        this.saveFahrzeugState(farzeuge);
    }

    @Override
    public void loescheFahrzeug(Fahrzeug fahrzeug) {
        ArrayList<Fahrzeug> fahrzeuge = this.getFahrzeugList();
        int indexOfFahrzeug = fahrzeuge.indexOf(fahrzeug);
            System.out.println("removing fahrzeug." + indexOfFahrzeug);
        if( indexOfFahrzeug > -1 ) {
            fahrzeuge.remove(indexOfFahrzeug);
        }
        fahrzeuge.remove(fahrzeug);
        this.saveFahrzeugState(fahrzeuge);
    }

    private void saveFahrzeugState(ArrayList<Fahrzeug> fahrzeuge) {
        try {
            FileOutputStream fos = new FileOutputStream(this.pfad);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(fahrzeuge);
            oos.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
