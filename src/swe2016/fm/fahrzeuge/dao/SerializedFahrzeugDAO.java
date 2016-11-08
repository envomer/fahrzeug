package swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeug.Fahrzeug;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializedFahrzeugDAO implements FahrzeugDAO
{
    public String pfad = null;
    OutputStream fileStream;
    ObjectOutputStream stream;

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
            e.printStackTrace();
        }

        return fahrzeuge;
//        ArrayList<Fahrzeug> fahrzeuge = new ArrayList<Fahrzeug>();
//        try
//        {
//            this.stream.writeObject("get fahrzeuge oder so");
//        }
//        catch ( IOException e ) { System.err.println( e ); }
//        finally { try { this.fileStream.close(); } catch ( Exception e ) { e.printStackTrace(); } }
//
//        return fahrzeuge;
    }

    @Override
    public Fahrzeug getFahrzeugbyId(int id) {
        return null;
    }

    @Override
    public void speichereFahrzeug(Fahrzeug fahrzeug) {
        ArrayList<Fahrzeug> farzeuge = this.getFahrzeugList();
        farzeuge.add(fahrzeug);
        try {
            FileOutputStream fos = new FileOutputStream(this.pfad);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(farzeuge);
            oos.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loescheFahrzeug(Fahrzeug fahrzeug) {
        try
        {
            this.stream.writeObject("delete????");
        }
        catch ( IOException e ) { System.err.println( e ); }
        finally { try { this.fileStream.close(); } catch ( Exception e ) { e.printStackTrace(); } }
    }
}
