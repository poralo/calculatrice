package fr.pauleudeline.polocalc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controleur implements PropertyChangeListener {
	
	Accumulateur model;
	GUI view;
    
    public Controleur() {
		model = new Accumulateur();
		model.addPropertyChangeListener(this);
    }
    
    public void setView(GUI gui) {
    	this.view = gui;
    }
    
    public void processNumpad(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		model.accumuler(value);
		this.view.change(this.model.getAccu());
	}
    
    public void processOperateur(ActionEvent event) {
    	String operateur = ((Button)event.getSource()).getText();
    	switch (operateur) {
		case "+":
			model.add();
			break;
		case "-":
			model.sub();
			break;
		case "/":
			model.div();
			break;
		case "*":
			model.mult();
			break;
		case "+/-":
			model.neg();
			break;
		case "Push":
			model.push();
			break;
		case "Swap":
			model.swap();
			break;
		case "DEL":
			model.backspace();
			break;
		case "C":
			model.drop();
			break;
		case "R":
			model.reset();
			break;
    	}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//this.output.setText((String) evt.getNewValue());
	}


}