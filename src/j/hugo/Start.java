package j.hugo;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class Start {

    public static void main(String[] args) throws DeploymentException, IOException {
        // TODO Auto-generated method stub
        WebSocketContainer container =ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8080/webTest/socket";
        Session s =        container.connectToServer(Socketclient.class, URI.create(uri));
        s.getBasicRemote().sendText("Send from Client");
        Session s2 =        container.connectToServer(Socketclient.class, URI.create(uri));
        s2.getBasicRemote().sendText("Send from Client");
        Session s3 =        container.connectToServer(Socketclient.class, URI.create(uri));
        s3.getBasicRemote().sendText("Send from Client");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        s.close();
        s2.close();
        s3.close();

    }

}
