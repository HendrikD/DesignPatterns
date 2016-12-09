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
public class AstOperationTest {
    
    public AstOperationTest() {
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
     * Test of apply method, of class Operation.
     */
    @Test
    public void testApply() {
        System.out.println("apply");
        Context c = new Context();
        AstOperand a = new AstValue(5);
        AstOperand b = new AstValue(3);
        AstOperation op = new AstOperation("*", a, b);
        Integer expResult = a.value(c).get() * b.value(c).get();
        Optional<Integer> result = op.apply(a, b, new Context()).value(c);
        assertEquals(expResult, result.get());
    }

    /**
     * Test of toString method, of class Operation.
     */
    @Test
    public void testToString() {
        System.out.println("apply");
        AstOperand a = new AstValue(5);
        AstOperand b = new AstValue(3);
        AstOperation op = new AstOperation("*", a, b);
        String expResult = "*";
        String result = op.toString();
        assertEquals(expResult, result);
    }
    
}
