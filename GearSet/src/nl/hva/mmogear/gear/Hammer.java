package nl.hva.mmogear.gear;

/**
 *
 * @author <Jouw naam hier!!!>
 */
public class Hammer extends Weapon {

    //NIET AANPASSEN, DIT IS AUTOMATISCH GEGENEREERD!
    private static final long serialVersionUID = 2318490363317432437L;

    @Override
    public int calcDamage(){
        return (int)((getRawDamage()) + ((1.0/3.0) * getElementalDamage()));
    }

}