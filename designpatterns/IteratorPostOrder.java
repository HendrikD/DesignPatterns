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
public class IteratorPostOrder extends Iterator{

    @Override
    public void traverse(Ast ast) {
        if(this.visitor == null)
            throw new NullPointerException("Visitor must be set to call traverse");
        if(ast instanceof AstOperation){
            AstOperation op = (AstOperation)ast;
            visitor.visitOperationStart(op);
            traverse(op.getLeft());
            traverse(op.getRight());
            ast.accept(this.visitor); 
            visitor.visitOperationEnd(op);
        } else{
            ast.accept(this.visitor);
        }    
    }    
}
