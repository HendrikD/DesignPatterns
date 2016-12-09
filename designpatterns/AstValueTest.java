/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hendrik
 */
public class AstValueTest {
    
    public AstValueTest() {
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
     * Test of value method, of class Value.
     */
    @Test
    public void testValue() {
        AstValue v = new AstValue(5);
        Optional<Integer> expResult = Optional.of(5);
        Context c = new Context();
        Optional<Integer> result = v.value(c);
        assertEquals(expResult, result);
    }
    
}
