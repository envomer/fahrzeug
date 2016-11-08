import at.ac.univie.swe2016.fm.FahrzeugManagement;
import at.ac.univie.swe2016.fm.fahrzeug.PKW;

public class Main
{
    public static void main(String[] args)
    {
        FahrzeugManagement man = new FahrzeugManagement();

        PKW pkw = new PKW("Omer", "Mer", 2000,20000.0, 1);
        man.addFahrzeug(pkw);

        System.out.println("LKW:" + man.countLKW());
        System.out.println("PKW:" + man.countPKW());
        System.out.println("All fahrzeuge:" + man.countFahrzeuge());
    }
}
