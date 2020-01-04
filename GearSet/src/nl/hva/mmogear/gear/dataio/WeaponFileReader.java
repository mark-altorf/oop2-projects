package nl.hva.mmogear.gear.dataio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;
import nl.hva.mmogear.gear.Hammer;
import nl.hva.mmogear.gear.LongSword;
import nl.hva.mmogear.gear.Weapon;
import nl.hva.mmogear.gear.util.WeaponException;

/**
 *
 * @author <Jouw naam hier!!!>
 */
public class WeaponFileReader {
    private static final String WEAPON_FILE = "weapon.dat";

    public List<Weapon> readWeaponsFromFile() throws WeaponException{

        ArrayList weapons = new ArrayList();
        boolean eof = false;
        File weaponFile = new File(WEAPON_FILE);
        try {
            FileInputStream fis = new FileInputStream(weaponFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            while (!eof) {
                weapons.add((Weapon) ois.readObject());
            }
            ois.close();

        } catch (EOFException e) {
            eof = true;
        } catch (IOException e) {
            throw new WeaponException("Dit geeft bij het lezen een IO fout op file "+WEAPON_FILE+".");

        } catch (ClassNotFoundException e){
            throw new WeaponException("De klasse in file "+WEAPON_FILE+" bestaat niet.");
        }

        return weapons;
    }
        
}
