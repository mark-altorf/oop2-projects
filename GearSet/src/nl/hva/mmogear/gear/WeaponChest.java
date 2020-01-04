package nl.hva.mmogear.gear;

import java.util.ArrayList;
import java.util.List;
import nl.hva.mmogear.gear.dataio.WeaponFileReader;
import nl.hva.mmogear.gear.util.WeaponException;
import nl.hva.mmogear.gear.util.WeaponSort;

/**
 *
 * @author <Jouw naam hier!!!>
 */
public class WeaponChest {

    private WeaponFileReader weaponFileReader;
    private List<Weapon> weapons;

    public WeaponChest(WeaponFileReader weaponFileReader) {
        try {
            this.weaponFileReader = weaponFileReader;
            loadAndSortWeapons();
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    public List<Weapon> getHammers() {
        ArrayList<Weapon> hammers = new ArrayList<>();
        for (Weapon weapon : weapons) {
            if (weapon instanceof Hammer) {
                hammers.add(weapon);
            }
        }
        return hammers;
    }

    public List<Weapon> getLongSwords() {
        ArrayList<Weapon> longswords = new ArrayList<>();
        for (Weapon weapon : weapons) {
            if (weapon instanceof LongSword) {
                longswords.add(weapon);
            }
        }
        return longswords;
    }

    public List<Weapon> getAllWeapons() {
        return this.weapons;
    }

    public void loadAndSortWeapons() throws WeaponException {
        weapons = weaponFileReader.readWeaponsFromFile();
        this.weapons.sort(new WeaponSort());
    }
}
