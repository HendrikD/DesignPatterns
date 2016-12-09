/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

public abstract class VisitorPrint extends Visitor{

    protected String result = "";
    private Context c = new Context();
    
    @Override
    protected void visitOperand(AstOperand op) {
        result += op.toString(c);
    }

    @Override
    protected void visitOperation(AstOperation op) {  
        result += result.length() > 0 ? " " + op.toString() + " " : op.toString();
    }
    
    public String get(){
    	if(result.length() > 0 && result.charAt(0) == '(' && result.charAt(result.length()-1) == ')'){
    		result = result.substring(1, result.length()-1);
    	}
        return result;
    }
}
