package javafxapplication;

import org.junit.Test;
import util.Fout;

import static org.junit.Assert.assertEquals;

public class FoutTest {
    
    @Test
    public void testFout() {
        System.out.println("Fout");
        Fout instance = new Fout("melding");
        String expResult = "melding";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }
}
