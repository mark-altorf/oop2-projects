package repositories;

import helpers.KlantException;
import models.Klant;

import java.io.Serializable;
import java.util.List;

/**
 * Interface voor een repository van klanten
 *
 * @author HvA HBO-ICT
 */
public interface IKlantRepository extends Serializable {

    List<Klant> getAlleKlanten();
    void laden() throws KlantException;
    void opslaan() throws KlantException;
}
