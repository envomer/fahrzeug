import at.ac.univie.swe2016.fm.FahrzeugManagement;
import at.ac.univie.swe2016.fm.fahrzeug.LKW;
import at.ac.univie.swe2016.fm.fahrzeug.PKW;

public class Main
{
    public static void main(String[] args)
    {
        FahrzeugManagement man = new FahrzeugManagement();

        PKW pkw = new PKW("Omer", "Mer", 2000,20000.0, 11);
        pkw.setLetzteUeberpruefung();
        man.addFahrzeug(pkw);
        System.out.println(pkw.toString());

        LKW lkw = new LKW("Omer", "Mer", 2000,20000.0, 2);
        man.addFahrzeug(lkw);
        System.out.println(lkw.toString());

        System.out.println("LKW:" + man.countLKW());
        System.out.println("PKW:" + man.countPKW());
        System.out.println("All fahrzeuge:" + man.countFahrzeuge());

//        Fahrzeuge ff = man.
        man.removeFahrzeug(pkw);
//        man.removeFahrzeug(lkw);

        System.out.println("LKW:" + man.countLKW());
        System.out.println("PKW:" + man.countPKW());
        System.out.println("All fahrzeuge:" + man.countFahrzeuge());
    }
}
