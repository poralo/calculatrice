package fr.pauleudeline.polocalc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.EmptyStackException;

public class Accumulateur implements IAccumulateur{
	
	private Pile memoire;
	private PropertyChangeSupport emetteur = new PropertyChangeSupport(this);
	private String acc;
	
	public Accumulateur() {
		this.acc = "";
		memoire = new Pile();
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		emetteur.addPropertyChangeListener(listener);
	}
	
	public String getAccu() {
		return this.acc;
	}
		
	@Override
	public void push() {
		System.out.println("Nouvelle entrée dans la pile : " + this.acc);
		this.memoire.push(Double.parseDouble(this.acc));
		String oldValue = this.acc;
		this.acc = "";
		emetteur.firePropertyChange("value", oldValue, this.acc);
	}

	@Override
	public void drop() {
		try {
			this.memoire.drop();
		} catch (EmptyStackException e) {
			System.out.println("La pile est vide");
		}
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
		String oldValue = this.acc;
		this.acc = "-" + this.acc;
		emetteur.firePropertyChange("value", oldValue, this.acc);
		
	}

	@Override
	public void backspace() {
		String oldValue = this.acc;
		this.acc = this.acc.substring(0, this.acc.length() - 1);
		emetteur.firePropertyChange("value", oldValue, this.acc);
		
	}

	@Override
	public void accumuler(String character) {
		String oldValue = this.acc;
		this.acc += character;
		emetteur.firePropertyChange("value", oldValue, this.acc);
		
	}

	@Override
	public void reset() {
		String oldValue = this.acc;
		this.acc = "";
		emetteur.firePropertyChange("value", oldValue, this.acc);
		memoire = new Pile();
		
	}

}
