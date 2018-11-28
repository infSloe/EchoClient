import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.effect.*;
import javafx.scene.Group;

import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;

public class View extends GridPane
{
    private EchoClient client;
    private TextField eingabe, ausgabe;

    public View(EchoClient client_)
    {
        client = client_;
        guiErstellen();
    }

    public void guiErstellen()
    {   
        Text titel = new Text("Hallo Echo!");
        Text txtEingabe = new Text("Sag mal was:");
        eingabe = new TextField();
        Button button = new Button("senden");
        button.setOnAction(e -> buttonGedrueckt());
        Text txtAusgabe = new Text("Antwort:");
        ausgabe = new TextField();
        add(titel,0,0);
        add(txtEingabe,0,1);
        add(eingabe,0,2);
        add(button,0,3);
        add(txtAusgabe,1,1);
        add(ausgabe,1,2);

        // Aussehen
        titel.setFont(new Font(30));
        titel.setFill(Color.WHITE);
        txtEingabe.setFont(new Font(20));
        txtAusgabe.setFont(new Font(20));
        setPadding(new Insets(20));
        setVgap(10);
        setHgap(10);
        setBackground(new Background(new BackgroundFill(Color.SKYBLUE, null, null)));

    }

    public void buttonGedrueckt()
    {
        String nachricht = eingabe.getText();
        String antwort = client.sendenEmpfangen(nachricht);
        ausgabe.setText(antwort);

    }
}
