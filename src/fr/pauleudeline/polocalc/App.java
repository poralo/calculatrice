package fr.pauleudeline.polocalc;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	Controleur controleur = new Controleur();
    	GUI gui = new GUI(controleur, primaryStage);
    	gui.affiche();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
