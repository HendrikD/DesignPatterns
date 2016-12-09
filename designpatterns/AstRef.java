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
public class AstRef extends AstOperand {
	String id;

	public String getId() {
		return id;
	}

	public AstRef(String id) {
		this.id = id;
	}

	@Override
	public Optional<Integer> value(Context c) {
		if (c.variables.containsKey(id))
			return Optional.of(c.variables.get(id));
		else
			return Optional.empty();
	}

	@Override
	public String toString(Context c) {
		if (this.value(c).isPresent())
			return this.id;
		else
			return "?" + id;
	}

	@Override
	void accept(Visitor v) {
		v.visitOperand(this);
	}

}
