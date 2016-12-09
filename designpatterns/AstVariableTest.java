/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author hendrik
 */
public class AstVariableTest {
	
	Context ctx;
    
    public AstVariableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ctx = new Context();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class Variable.
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testDoubleCreateShouldThrow() {
        String id = "a";
        Integer value = 5;
        ctx.variables.put(id, value);
        ctx.variables.put(id, value);
    }

    /**
     * Test of value method, of class Variable.
     */
    @Test
    public void testValue() {
        String id = "a";
        Integer value = 5;
        ctx.variables.put(id, value);
        AstRef a = new AstRef("a");
        assertEquals(value, a.value(ctx).get());
    }
    
        /**
     * Test of value method, of class Variable.
     */
    @Test
    public void testValueEmpty() {
        AstRef a = new AstRef("a");
        assertEquals(Optional.empty(), a.value(ctx));
    }
    
}
