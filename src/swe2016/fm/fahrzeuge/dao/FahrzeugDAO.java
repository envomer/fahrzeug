package swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeug.Fahrzeug;

import java.util.ArrayList;
import java.util.List;

public interface FahrzeugDAO
{
    public ArrayList getFahrzeugList();

    public Fahrzeug getFahrzeugbyId(int id);

    public void speichereFahrzeug(Fahrzeug fahrzeug);

    public void loescheFahrzeug(Fahrzeug fahrzeug);
}
