/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

import java.util.Optional;

/**
 *
 * @author hendrik
 */
public class AstValue extends AstOperand{
    protected Integer value;
    public AstValue(Integer num){
        value = num;
    };

    @Override
    public Optional<Integer> value(Context c) {
        return Optional.of(value);
    }

    @Override
    public void accept(Visitor v) {
        v.visitOperand(this);
    }
    
    @Override
    public String toString(Context c){
        return value.toString();
    }
}
