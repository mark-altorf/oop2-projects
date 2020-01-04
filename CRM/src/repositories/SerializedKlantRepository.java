package repositories;

import helpers.KlantException;
import models.Klant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Een serialized versie van de klanten repository
 *
 * @author HvA HBO-ICT
 */
public class SerializedKlantRepository implements IKlantRepository {

    private final String KLANTEN_FILE = "klanten.dat";

    private List<Klant> klanten;

    public SerializedKlantRepository() {
        klanten = new ArrayList<>();
    }

    @Override
    public List<Klant> getAlleKlanten() {
        return klanten;
    }

    public void laden() throws KlantException {
        //TODO: Implementeer deze methode
        File file = new File(KLANTEN_FILE);

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            klanten = (List<Klant>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new KlantException(e.getMessage());
        } catch (IOException e) {
            throw new KlantException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new KlantException(e.getMessage());
        }
    }

    public void opslaan() throws KlantException {
        //TODO: Implementeer deze methode
        File file = new File(KLANTEN_FILE);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(klanten);
        } catch (FileNotFoundException e) {
            throw new KlantException(e.getMessage());
        } catch (IOException e) {
            throw new KlantException(e.getMessage());
        }
    }
}
