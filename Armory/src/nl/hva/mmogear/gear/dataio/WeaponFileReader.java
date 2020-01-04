package nl.hva.mmogear.gear.dataio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

   public List<Weapon> readWeaponsFromFile () throws WeaponException {

       ArrayList <Weapon> list = new ArrayList<>();
       boolean eof = false;
       try {
           FileInputStream fis = new FileInputStream(WEAPON_FILE);
           ObjectInputStream oos = new ObjectInputStream(fis);


           while (!eof) {
               list.add((Weapon) oos.readObject());
           }
       }catch (EOFException e) {
           eof = true;
       } catch (IOException e) {
          throw new WeaponException("Ouputstream does not work");
       } catch (ClassNotFoundException e){
           throw new WeaponException("Weapon does not exist");
        }
        return list;
        }

        }
