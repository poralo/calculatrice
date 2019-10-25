package fr.pauleudeline.polocalc;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI implements IView  {
	private Controleur controleur;
	private Stage primaryStage;
	
	Text outText;
	
	public GUI(Controleur controleur, Stage primaryStage) {
		this.controleur = controleur;
		this.controleur.setView(this);
		this.primaryStage = primaryStage;
		
		outText = new Text();
	}

	@Override
	public void affiche() {
		VBox clavierBox = new VBox();
		HBox chifBox = new HBox();
		VBox chiffres = new VBox();
		
		Rectangle rectangle = new Rectangle();
		clavierBox.getChildren().add(rectangle);
		
		outText.setText("");
		clavierBox.getChildren().add(outText);
		
		HBox hbox = new HBox();
		int c = 9;
		for (int i = 0; i < 3; i++) {
			hbox = new HBox();
			for (int j = 0; j < 3; j++) {
				
				String vString = "" + c;
				Button btn = new Button(vString);
				btn.addEventHandler(ActionEvent.ACTION,
						 e -> {
							 this.controleur.processNumpad(e);
							});
				hbox.getChildren().add(btn);
				c--;
			}
			chiffres.getChildren().add(hbox);
		}
		
		hbox = new HBox();
		Button btn = new Button(".");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		hbox.getChildren().add(btn);
		btn = new Button("0");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processNumpad(e);
					});
		hbox.getChildren().add(btn);
		btn = new Button("+/-");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		hbox.getChildren().add(btn);
		chiffres.getChildren().add(hbox);
		
		btn = new Button("Push");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		chiffres.getChildren().add(btn);
		
		chifBox.getChildren().add(chiffres);
		
		VBox vBox = new VBox();
		btn = new Button("*");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		vBox.getChildren().add(btn);
		btn = new Button("/");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		vBox.getChildren().add(btn);
		btn = new Button("+");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		vBox.getChildren().add(btn);
		btn = new Button("-");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		vBox.getChildren().add(btn);
		chifBox.getChildren().add(vBox);
		
		vBox = new VBox();
		btn = new Button("DEL");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		vBox.getChildren().add(btn);
		btn = new Button("C");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		vBox.getChildren().add(btn);
		btn = new Button("Reset");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		vBox.getChildren().add(btn);
		btn = new Button("Swap");
		btn.addEventHandler(ActionEvent.ACTION,
				 e -> {
					 this.controleur.processOperateur(e);
					});
		vBox.getChildren().add(btn);
		chifBox.getChildren().add(vBox);
		
		clavierBox.getChildren().add(chifBox);
		
		Scene mainScene = new Scene(clavierBox);
		
		primaryStage.setTitle("Calculatrice");
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	@Override
	public void change(List<String> data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void change(String accu) {
		this.outText.setText(accu);
	}

}
