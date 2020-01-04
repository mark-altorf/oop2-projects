
package nl.hva.mmogear.gear.util;


import nl.hva.mmogear.gear.Weapon;

import java.util.Comparator;

/**
 *
 * @author <Jouw naam hier!!!>
 */
public class WeaponSort implements Comparator<Weapon> {

    @Override
    public int compare(Weapon o1, Weapon o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result != 0){
            return result;
        } else {
            return o1.getRawDamage() - o2.getRawDamage();
        }
    }
}
