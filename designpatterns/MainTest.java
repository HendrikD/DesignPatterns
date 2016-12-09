/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author hendrik
 */
public class MainTest {
    
    public MainTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void visitorEvaluate() {
        Integer a = -5;
        Integer b = 2;
        Integer c = 10;
        Integer d = 40;
        
        Context context = new Context();
        
        context.variables.put("a", -5);
        context.variables.put("b", 2);
        context.variables.put("c", 10);
        context.variables.put("d", 40);
        
        VisitorEvaluate visitor = new VisitorEvaluate(context);
        visitor.start(Ast.REICHARD);
        
        Optional<Integer> expected = Optional.of(((( a + b) *( a - c)) +(( b * d) - a)));
        Optional<Integer> actual = visitor.get().value(context);
        
        System.out.println("((( a + b) *( a - c)) +(( b * d) - a)) Expected: " + expected + ", actual: " + actual);
        assertEquals(expected, actual);
    }
    
    @Test
    public void visitorEvaluate2() {
        Integer a = -5;
        Integer b = 2;
        Integer c = 10;
        Integer d = 40;
        
        Context context = new Context();
        
        context.variables.put("x", -5);
        
        context.variables.put("a", -5);
        context.variables.put("b", 2);
        context.variables.put("c", 10);
        context.variables.put("d", 40);
        
        VisitorEvaluate visitor = new VisitorEvaluate(context);
        visitor.start(Ast.REICHARD2);
        
        Optional<Integer> expected = Optional.of(((( a + b) *( a - c)) +(( b * d) - a)));
        Optional<Integer> actual = visitor.get().value(context);
        
        System.out.println("(?(x<0)( x = (( a + b) *( a - c)) +(( b * d) - a))) Expected: " + expected + ", actual: " + actual);
        
        assertEquals(expected, actual);
    }
    
    
    
    @Test
    public void visitorStringUndeclared() {
        VisitorPrint visitor = new VisitorPrintInOrder();
        visitor.start(Ast.REICHARD);
        
        String expected = "((?a + ?b) * (?a - ?c)) + ((?b * ?d) - ?a)";
        String actual = visitor.get();
        
        System.out.println("Expected: " + expected + ", actual: " + actual);
        assertEquals(expected, actual);
    }
}
