package swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SerializedFahrzeugDAO implements FahrzeugDAO
{
    public String pfad = null;

    public SerializedFahrzeugDAO(String pfad) {
        this.pfad = pfad;
    }

    @Override
    public ArrayList getFahrzeugList() {
        ObjectOutputStream daten = null;
        OutputStream fos = null;
        try
        {
            fos = new FileOutputStream( pfad );
            daten = new ObjectOutputStream( fos );
        }
        catch ( IOException e ) { System.err.println( e ); }
        finally { try { fos.close(); } catch ( Exception e ) { e.printStackTrace(); } }

        return new ArrayList();
    }

    @Override
    public Fahrzeug getFahrzeugbyId(int id) {
        return null;
    }

    @Override
    public void speichereFahrzeug(Fahrzeug fahrzeug) {

    }

    @Override
    public void loescheFahrzeug(Fahrzeug fahrzeug) {

    }
}
