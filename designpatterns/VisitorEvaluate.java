/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import java.util.ArrayDeque;
import java.util.Deque;

public class VisitorEvaluate extends Visitor{

	public enum State{
		Start
	}
	
    private Deque<AstOperand> stack = new ArrayDeque<>();
    protected State state = State.Start;
    protected Context context;
    
    public VisitorEvaluate(Context context) {
    	this.context = context;
    }
    
    @Override
    protected void visitOperand(AstOperand op) {
        stack.push(op);
    }

    @Override
    protected void visitOperation(AstOperation op) {
        if(stack.size() < 2)
            throw new AssertionError("Not enough arguments for operator " + op.toString());
        AstOperand b = stack.pop();
        AstOperand a = stack.pop();
        AstOperand x = op.apply(a, b, context);
        stack.push(x);
    }
    
    public AstOperand get(){
        if(stack.size() != 1)
            throw new AssertionError("Stack is in an invalid state!");
        return stack.pop();
    }    
    @Override
    protected Iterator makeIterator(){
        return new IteratorPostOrder();
    }

    @Override
    protected void visitOperationStart(AstOperation op) {}

    @Override
    protected void visitOperationEnd(AstOperation op) {}
}
