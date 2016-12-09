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
public abstract class AstOperand extends Ast{
    public abstract Optional<Integer> value(Context c);

    public String toString(Context c){
        return value(c).toString();
    };
}
