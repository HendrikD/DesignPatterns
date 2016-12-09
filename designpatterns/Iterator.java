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
public abstract class Iterator {
    protected Visitor visitor;
    public void setVisitor(Visitor v){
        this.visitor = v;
    };
    public abstract void traverse(Ast ast);
}
