package data;

import model.Verjaardag;
import util.Fout;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bestand {

    private String filenaam;
    File file;

    public Bestand(String filenaam) {
        this.filenaam = filenaam;
        file = new File(filenaam);
    }

    public List<Verjaardag> leesTerug() throws Fout {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        ArrayList<Verjaardag> listVerjaardag = new ArrayList<>();

        try {
            fis = new FileInputStream(filenaam);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            listVerjaardag = (ArrayList<Verjaardag>) ois.readObject();
            ois.close();

        } catch (ClassNotFoundException e) {
            throw new Fout("De java klasse in het input bestand " + filenaam + " bestaat niet");
        } catch (FileNotFoundException e) {
            throw new Fout("Het input bestand " + filenaam + " bestaat niet");
        } catch (EOFException e) {
        } catch (IOException e) {
            throw new Fout("Algemene IO Fout op " + filenaam);
        }

        return listVerjaardag;
    }


    public void schrijfWeg(List<Verjaardag> verjaardagen) throws Fout{
        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream ops = new ObjectOutputStream(bos);

            ops.writeObject(verjaardagen);
            ops.close();

        } catch (IOException e) {
            throw new Fout("Er was een Output Fout op bestand: " + filenaam);
        }


    }
}
