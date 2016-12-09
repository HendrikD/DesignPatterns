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

public abstract class Visitor{
    protected void visitOperand(AstOperand op){};
    protected void visitOperation(AstOperation op){};
    protected void visitOperationStart(AstOperation op){};
    protected void visitOperationEnd(AstOperation op){};
    
    public void start(Ast ast){
        Iterator it = makeIterator();
        it.setVisitor(this);
        it.traverse(ast);
    }
    protected Iterator makeIterator(){
        return new IteratorPostOrder();
    };
}
