package nl.hva.mmogear.gear;

import java.io.Serializable;

/**
 *
 * @author <Jouw naam hier!!!>
 */
public abstract class Weapon implements Serializable {

    //NIET AANPASSEN, DIT IS AUTOMATISCH GEGENEREERD!
    private static final long serialVersionUID = 1438799507704145514L;

    private String name;
    private int elementalDamage;
    private int rawDamage;

    public abstract int calcDamage();

    @Override
    public String toString() {
        return name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public int getElementalDamage() {
        return elementalDamage;
    }

    public int getRawDamage() {
        return rawDamage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElementalDamage(int elementalDamage) {
        this.elementalDamage = elementalDamage;
    }

    public void setRawDamage(int rawDamage) {
        this.rawDamage = rawDamage;
    }
}
