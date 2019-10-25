package fr.pauleudeline.calc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controleur implements PropertyChangeListener {
	
	Accumulateur model;

    @FXML
    private Text output;
    
    @FXML
    private Text pile;
    
    public Controleur() {
		model = new Accumulateur();
		
		model.accumuler("6");
		model.accumuler("7");
		model.push();
	}
    
    @FXML
    private void processNumpad(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		model.accumuler(value);
		output.setText(model.getAccumulateur());
	}
    
    @FXML
    private void processOperateur(ActionEvent event) {
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
    	}
    	output.setText(model.getAccumulateur());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getSource());
		
	}


}