// aus Java von Kopf bis Fu8
import java.io.*;
import java.io.IOException;
import java.net.Socket;

public class EchoClient {
    String serverAdresse;
    int portNummer;
    Socket socket;
    PrintWriter writer;
    BufferedReader reader;

    public EchoClient(String adresse, int port)
    {
        serverAdresse = adresse;
        portNummer = port;
        verbinden();
    }

    public void verbinden()
    {
        try {
            socket = new Socket(serverAdresse, portNummer);
            writer = new PrintWriter(socket.getOutputStream());
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader    = new BufferedReader(streamReader);
        }
        catch(IOException ex) {}
    }

    public String sendenEmpfangen(String zeile)
    {
        String antwort = "";
        if (socket != null)
        {
            try{
                // Sende die Zeile
                System.out.println("Möchte das senden : " + zeile);               
                writer.println(zeile);
                writer.flush();

                // Lese die Antwort                
                antwort = reader.readLine();
                System.out.println("Die Antwort:" + antwort);
            }catch(IOException ex)
            {}
        }
        return antwort;
    }

}

