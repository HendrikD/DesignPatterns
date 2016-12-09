/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import java.util.HashMap;

public class AstOperation extends Ast{    
    ////////////////////////////////////
    // Hauptteil
    ////////////////////////////////////
    
    private TriFunction<AstOperand, AstOperand, AstOperand, Context> op;
    private String symbol;
    private Ast left;
    private Ast right;
    
    public AstOperation(String operatorString, Ast left, Ast right){
        this.op = operations.get(operatorString);
        this.symbol = operatorString;
        this.left = left;
        this.right = right; 
    }
    
    public AstOperand apply(AstOperand a, AstOperand b, Context c){
        return op.apply(a, b, c); 
    }
    
    public String toString(){
        return symbol;
    }
    
    @Override
    public void accept(Visitor v) {
        v.visitOperation(this);
    }

    public Ast getLeft() {
        return left;
    }

    public Ast getRight() {
        return right;
    }
    
	////////////////////////////////////
	//  Hilfsteil
	////////////////////////////////////
	
	// Wird benötigt, um Funktionsobjekte mit 3 Parametern einfach deklarieren zu können.
	@FunctionalInterface
	public interface TriFunction<R, T, U, S> {
	    R apply(T t, U u, S s);
	}
	
	// Sammlung von Funktionsobjekten, um einfach AstOperationen erzeugen zu können.
	@SuppressWarnings("serial")
	public static HashMap<String, TriFunction<AstOperand, AstOperand, AstOperand, Context>> operations = new HashMap<String, TriFunction<AstOperand, AstOperand, AstOperand, Context>>(){{
		
		// Arithmetic Operators
        put("+", (a, b, c)->new AstValue(a.value(c).orElse(0) + b.value(c).orElse(0)));
        put("-", (a, b, c)->new AstValue(a.value(c).orElse(0) - b.value(c).orElse(0)));
        put("*", (a, b, c)->new AstValue(a.value(c).orElse(1) * b.value(c).orElse(1)));
        put("/", (a, b, c)->new AstValue(a.value(c).orElse(1) / b.value(c).orElse(1)));
        
        // If Statement
        put("?", (a, b, c)->{
        	if(a.value(c).orElse(0)  != 0) 
        		return b; 
        	return new AstValue(0);
        });
        
        // Assign Statement
        put("=", (a, b, c)->{
        	c.variables.put(((AstRef)a).getId(), b.value(c).orElse(0)); 
        	return a;
        });
        
        // Boolean Operators
        put("<",  (a,b, c)->{return a.value(c).orElse(0) <  b.value(c).orElse(0) ?  new AstValue(1) : new AstValue(0); });
        put(">",  (a,b, c)->{return a.value(c).orElse(0) >  b.value(c).orElse(0) ?  new AstValue(1) : new AstValue(0); });
        put("<=", (a,b, c)->{return a.value(c).orElse(0) <=  b.value(c).orElse(0) ?  new AstValue(1) : new AstValue(0); });
        put(">=", (a,b, c)->{return a.value(c).orElse(0) >=  b.value(c).orElse(0) ?  new AstValue(1) : new AstValue(0); });
        put("==", (a,b, c)->{return a.value(c).orElse(0) ==  b.value(c).orElse(0) ?  new AstValue(1) : new AstValue(0); });
    }};
}