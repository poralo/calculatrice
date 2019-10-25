package fr.pauleudeline.polocalc;

import java.util.Stack;

public class Pile extends Stack<Double> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void drop() {
		this.pop();
	}
	
	public void swap() {
		double a = this.pop();
		double b = this.pop();
		
		this.push(a);
		this.push(b);
	}
}
