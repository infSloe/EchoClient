import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Attribute 
    EchoClient client;
    View view;

    public void start(Stage stage) {
        client = new EchoClient("127.0.0.1",4242);
        Pane root = new View(client);
        Scene scene = new Scene(root, 600,250);         
        stage.setTitle("App");
        stage.setScene(scene);
        stage.show();
    }

}