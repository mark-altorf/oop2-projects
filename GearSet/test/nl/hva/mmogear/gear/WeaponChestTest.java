/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.mmogear.gear;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.hva.mmogear.dataio.WeaponTestReader;
import nl.hva.mmogear.gear.dataio.WeaponFileReader;
import nl.hva.mmogear.gear.util.WeaponException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martijnthorig
 */
public class WeaponChestTest {
    
    public WeaponChestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHammers method, of class WeaponChest.
     * */
    @Test
    public void testGetHammers() {
        WeaponFileReader weaponsLoader = new WeaponTestReader();

        WeaponChest instance =null;
        try {
            instance = new WeaponChest(weaponsLoader);
            instance.loadAndSortWeapons();
        } catch (WeaponException ex) {
            Logger.getLogger(WeaponChestTest.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        List<Weapon> hammers = instance.getHammers();

        int hammerCount = 0;

        for(Weapon w : hammers) {
            hammerCount++;
        }

        assertEquals(11, hammerCount);
    }

    /**
     * Test of getLongSword method, of class WeaponChest.
     * */
    @Test
    public void testGetLongSword() {
        WeaponFileReader weaponsLoader = new WeaponTestReader();
        
        WeaponChest instance=null;
        try {
            instance = new WeaponChest(weaponsLoader);
            instance.loadAndSortWeapons();
        } catch (WeaponException ex) {
            Logger.getLogger(WeaponChestTest.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        List<Weapon> longSwords = instance.getLongSwords();
        
        int longSwordCount = 0;
        
        for(Weapon w : longSwords) {
            longSwordCount++;
        }
        
        assertEquals(13, longSwordCount);
    }

    /**
     * Test of getAll method, of class WeaponChest.
     */
    @Test
    public void testGetAllWeapons() {
        WeaponFileReader weaponsLoader = new WeaponTestReader();
        WeaponChest instance = null;
        try {
            instance = new WeaponChest(weaponsLoader);

            instance.loadAndSortWeapons();
        } catch (WeaponException ex) {
            Logger.getLogger(WeaponChestTest.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        List<Weapon> weapons = instance.getAllWeapons();
        
        int count = 0;
        
        for(Weapon w : weapons) {
            count++;
        }
        
        assertEquals(24, count);
    }

}
