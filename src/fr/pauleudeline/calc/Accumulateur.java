package fr.pauleudeline.calc;

import java.beans.PropertyChangeSupport;
import java.util.EmptyStackException;

public class Accumulateur implements IAccumulateur{
	
	private Pile memoire;
	private PropertyChangeSupport emetteur;
	private String acc;
	
	public Accumulateur() {
		this.acc = "";
		memoire = new Pile();
	}
	
	public String getAccumulateur() {
		return acc;
	}

	@Override
	public void push() {
		System.out.println("Nouvelle entrée dans la pile : " + this.acc);
		this.memoire.push(Double.parseDouble(this.acc));
		this.acc = "";
	}

	@Override
	public void drop() {
		this.memoire.drop();
	}

	@Override
	public void swap() {
		this.memoire.swap();
	}

	@Override
	public void add() {
		try {
			double a = this.memoire.pop();
			double b = this.memoire.pop();
			
			this.memoire.push(a + b);
			System.out.println(a + b);
			
		} catch (EmptyStackException e) {
			System.out.println("L'opération ne peut pas être réalisée car la pile ne possède pas assez d'opérande !");
			
		}
		
	}

	@Override
	public void sub() {
		double a = this.memoire.pop();
		double b = this.memoire.pop();
		
		this.memoire.push(a - b);
		System.out.println(a - b);
		
	}

	@Override
	public void mult() {
		double a = this.memoire.pop();
		double b = this.memoire.pop();
		
		this.memoire.push(a * b);
		System.out.println(a * b);
		
	}

	@Override
	public void div() {
		double a = this.memoire.pop();
		double b = this.memoire.pop();
		
		this.memoire.push(a / b);
		System.out.println(a / b);
		
	}

	@Override
	public void neg() {
		this.acc = "-" + this.acc;
		
	}

	@Override
	public void backspace() {
		this.acc = this.acc.substring(0, this.acc.length() - 1);
		
	}

	@Override
	public void accumuler(String character) {
		this.acc += character;
		
	}

	@Override
	public void reset() {
		this.acc = "";
		
	}

}
