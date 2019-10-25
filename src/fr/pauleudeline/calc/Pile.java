package fr.pauleudeline.calc;

import java.util.Stack;

public class Pile extends Stack<Double> {

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
