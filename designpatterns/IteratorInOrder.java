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
public class IteratorInOrder extends Iterator{

    @Override
    public void traverse(Ast ast) {
        if(this.visitor == null)
            throw new NullPointerException("Visitor must be set to call traverse");
        if(ast instanceof AstOperation){
            AstOperation op = (AstOperation)ast;
            visitor.visitOperationStart(op);
            traverse(op.getLeft());
            ast.accept(this.visitor);
            traverse(op.getRight()); 
            visitor.visitOperationEnd(op);
        } else{
            ast.accept(this.visitor);
        } 
    }    
}
