package nl.hva.ac.driver;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import nl.hva.ac.model.Accommodatie;

/**
 * Poor man's testing framework.
 * *
 * @author michel.mercera
 */
public class MainAppTest {

    private static int aantalPunten = 0;

    public static void main(String[] args) {
          testStap1(0);
          testStap2(5);
          testStap3(15);
          testStap4(10);
          testStap9(20);
        
         
        System.out.println("Punten totaal zonder stap 5,6,7,8 en 10: " + aantalPunten);
        
    }

    public static void testStap1(int punten) {
        printS(1);
        if (MainApp.getLastNameAndStudentNumber().equals("Altorf, 500734051")) {
            printR(false);
        } else {
            printR(true);//probably
            aantalPunten += punten;
        }

    }

    public static void testStap2(int punten) {
        printS(2);
        nl.hva.ac.util.IllegaleAccommodatieException il = new nl.hva.ac.util.IllegaleAccommodatieException("Sorry!");
        if (il instanceof Exception) {
            if (il.getMessage().equalsIgnoreCase("Sorry!")) {
                printR(true);
                aantalPunten += punten;
            } else {
                printR(false);
            }
        } else {
            printR(false);
        }
    }

    public static void testStap3(int punten) {
        printS(3);
        boolean guestNegative = false;
        boolean nameNull = false;
        boolean nightNegative = false;
        boolean priceLessThanZero = false;
        try {

            Accommodatie hotel = new Accommodatie("Amstelhotel", 100, -5, 2);
            hotel.bevestig();

        } catch (nl.hva.ac.util.IllegaleAccommodatieException ex) {
            guestNegative = true;
        }
        try {
            Accommodatie hotel = new Accommodatie("Amstelhotel", 100, 5, -2);
            hotel.bevestig();

        } catch (nl.hva.ac.util.IllegaleAccommodatieException ex) {
            nightNegative = true;

        }
        try {
            Accommodatie hotel = new Accommodatie("", 100, 5, 2);
            hotel.bevestig();

        } catch (nl.hva.ac.util.IllegaleAccommodatieException ex) {
            nameNull = true;
        }
        try {
            Accommodatie hotel = new Accommodatie("Hotel Sing sing", -1, 5, 2);
            hotel.bevestig();
        } catch (nl.hva.ac.util.IllegaleAccommodatieException ex) {
            priceLessThanZero = true;
        }

        if (guestNegative && nameNull && nightNegative && priceLessThanZero) {
            printR(true);
            aantalPunten += punten;
        } else {
            printR(false);
        }

    }

    public static void testStap4(int punten) {
        printS(4);

        nl.hva.ac.util.AantalGastenComparator comp = new nl.hva.ac.util.AantalGastenComparator();

        Accommodatie h1 = new Accommodatie("Amstelhotel", 100, 1, 2);
        Accommodatie h2 = new Accommodatie("Amstelhotel", 100, 10, 2);
        boolean smaller = false;
        boolean equal = false;
        boolean bigger = false;
        if (comp.compare(h1, h2) < 0) {
            smaller = true;

        }
        if (comp.compare(h2, h1) > 0) {
            bigger = true;
        }
        Accommodatie h3 = new Accommodatie("Amstelhotel", 100, 10, 2);

        if (comp.compare(h2, h3) == 0) {
            equal = true;
        }
        if (smaller && equal && bigger) {
            aantalPunten += punten;
        }
        printR(smaller && equal && bigger);

    }

    public static void testStap9(int punten) {
        printS(9);

        int lazyCheck = 3; // just checks how many items there are....

        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("accommodaties.dat"));
            java.util.ArrayList<Accommodatie> acc = (java.util.ArrayList<Accommodatie>) ois.readObject();
            int check = acc.size();
            if (check == lazyCheck) {
                printR(true);
                aantalPunten += punten;
            } else {
                printR(false);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            printR(false);
        }

    }

    /**
     * Utility method om een test resultaat uit te printen
     *
     * @param geslaagd boolean als test geslaagd is of niet
     */
    private static void printR(boolean geslaagd) {
        String res = geslaagd ? "correct" : "niet correct";
        System.out.println("Resultaat: " + res);
    }

    /**
     * Utility method om een testnummer uit te printen
     *
     * @param i integer met stapnummer
     */
    private static void printS(Integer i) {
        System.out.println("--------------------------------------------");
        System.out.println("TEST STAP: " + i);
    }

}
