package nl.hva.mmogear.gear;

/**
 *
 * @author <Jouw naam hier!!!>
 */
public class LongSword extends Weapon {

    //NIET AANPASSEN, DIT IS AUTOMATISCH GEGENEREERD!
    private static final long serialVersionUID = 2318490363317432437L;


    @Override
    public int calcDamage() {
         return (int)((getRawDamage() * 0.2) + ((1.0 + (1.0/3.0)) * getElementalDamage()));
    }
}
