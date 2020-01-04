package nl.hva.mmogear.dataio;

import java.util.ArrayList;
import java.util.List;
import nl.hva.mmogear.gear.Hammer;
import nl.hva.mmogear.gear.LongSword;
import nl.hva.mmogear.gear.Weapon;
import nl.hva.mmogear.gear.dataio.WeaponFileReader;
import nl.hva.mmogear.gear.util.WeaponException;

/**
 * Helper class
 * @author martijnthorig
 */
public class WeaponTestReader extends WeaponFileReader {


    @Override
    public List<Weapon> readWeaponsFromFile() throws WeaponException {
        List<Weapon> weapons = new ArrayList<>();
        
        weapons.add(getHam("Obliteration's Footfall", 1092, 120));
        weapons.add(getLS("Blacksteel Long Sword I", 330, 120));
        weapons.add(getLS("Imperial Saber", 561, 300));
        weapons.add(getHam("Xeno Maph'agarna", 884, 180));
        weapons.add(getLS("Wyvern Blade Indigo", 627, 240));
        weapons.add(getHam("Hazak Vlafos", 988, 210));
        weapons.add(getLS("Blacksteel Long Sword II", 363, 150));
        weapons.add(getLS("Xeno Cypher", 594, 180));
        weapons.add(getHam("Magda Floga", 832, 330));
        weapons.add(getLS("Imperial Shimmer", 627, 300));
        weapons.add(getHam("Ragefire Magda Floga", 1144, 420));
        weapons.add(getLS("Wyvern Blade Blood", 528, 180));
        weapons.add(getHam("Nergal Crusher", 1040, 90));
        weapons.add(getLS("Divine Slasher", 693, 150));
        weapons.add(getHam("Pandemonium's Root", 1040, 270));
        weapons.add(getLS("Supremacy Blade", 561, 120));
        weapons.add(getLS("Wyvern Blade Azure", 561, 210));
        weapons.add(getHam("Binder Mace", 936, 210));
        weapons.add(getLS("Nergal Reaver", 627, 90));
        weapons.add(getHam("Icesteel Hammer", 988, 120));
        weapons.add(getHam("Daora's Colossus", 1040, 150));
        weapons.add(getLS("Extermination's Edge", 693, 120));
        weapons.add(getHam("Jail Hammer", 832, 180));
        weapons.add(getLS("Wyvern Blade Fall", 396, 150));
        
        return weapons;
    }
    
    private Weapon getLS(String name, int raw, int ele) {
        Weapon longSword = new LongSword();
        longSword.setElementalDamage(ele);
        longSword.setRawDamage(raw);
        longSword.setName(name);
        return longSword;
    }
    
    private Weapon getHam(String name, int raw, int ele) {
        Weapon hammer = new Hammer();
        hammer.setElementalDamage(ele);
        hammer.setRawDamage(raw);
        hammer.setName(name);
        return hammer;
    }

}
