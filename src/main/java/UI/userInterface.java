package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class userInterface extends Application{
	
	public void init() {
		
	}
	
	public void start(Stage stage) {
		BorderPane layout = new BorderPane();
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.setTitle("hello!");
		stage.show();
	}

}
