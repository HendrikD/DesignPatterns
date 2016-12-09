/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

public class VisitorPrintPreOrder extends VisitorPrint{
	@Override
	protected Iterator makeIterator() {
		return new IteratorPreOrder();
	}
}
