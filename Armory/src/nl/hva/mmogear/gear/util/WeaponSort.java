
package nl.hva.mmogear.gear.util;


import nl.hva.mmogear.gear.Weapon;

import java.util.Comparator;

/**
 *
 * @author <Jouw naam hier!!!>
 */
public class WeaponSort implements Comparator <Weapon> {

    public int compare(Weapon w1, Weapon w2) {
        int c = w1.getName().compareTo(w2.getName());

        if (c != 0) {
            return c;
        } else {
            return w1.getRawDamage() - w2.getRawDamage();
        }
    }
}

