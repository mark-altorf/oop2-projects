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

    private WeaponFileReader weaponReader;
    private List <Weapon> weapons;

    public WeaponChest(WeaponFileReader weaponReader) {
        this.weaponReader = weaponReader;
        try {
            loadAndSortWeapons();
        } catch (WeaponException e) {
            e.printStackTrace();
        }

    }

    public List<Weapon> getAllWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List <Weapon> getHammers(){
        List<Weapon> listHammers = new ArrayList<>();
        List<Weapon> listAll = getAllWeapons();

        for (Weapon e : listAll) {
            if(e instanceof Hammer) {
               listHammers.add(e);
            }
        }
        return listHammers;
    }
    public List <Weapon> getLongSwords(){
        List<Weapon> listLongswords = new ArrayList<>();
        List<Weapon> listAll = getAllWeapons();

        for (Weapon e : listAll){
            if ( e instanceof Hammer){
                listLongswords.add(e);
            }
        }
        return listLongswords;
    }

    public void loadAndSortWeapons() throws WeaponException{
        this.weapons = weaponReader.readWeaponsFromFile();
        this.weapons.sort(new WeaponSort());

    }


}