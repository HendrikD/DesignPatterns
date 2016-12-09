/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

/**
 *
 * @author hendrik
 */
public abstract class Ast {
    
    public static Ast REICHARD = new AstOperation("+", new AstOperation("*", new AstOperation("+", new AstRef("a"), new AstRef("b")) , new AstOperation("-", new AstRef("a"), new AstRef("c"))), new AstOperation("-", new AstOperation("*", new AstRef("b"), new AstRef("d")), new AstRef("a")));
    public static Ast REICHARD2 = new AstOperation("?", new AstOperation("<", new AstRef("x"), new AstValue(0)), new AstOperation("+", new AstOperation("*", new AstOperation("+", new AstRef("a"),  new AstRef("b")), new AstOperation("-", new AstRef("a"),  new AstRef("c"))), new AstOperation("-", new AstOperation("*", new AstRef("b"),  new AstRef("d")),  new AstRef("a"))));
    
    abstract void accept(Visitor v);
}
