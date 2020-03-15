package j.hugo;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class Socketclient {
    
    @OnMessage
    public void onMessage(String a, Session s) {
        System.out.println(s.getId()+" "+a);
        if(a.equals("Broadcast")) {
            s.getAsyncRemote().sendText("BroadCast received");
        }
    }
    
    @OnError
    public void onError(Throwable t) {
        System.out.println(t.getMessage());
        System.out.println("On error Client");
    }
    
    
    @OnOpen
    public void onOpen(Session s) {
        System.out.println("On Open Client "+s.getId());
    }
    
    @OnClose
    public void onClose(CloseReason t) {
        System.out.println("On Close Client");
    }
}
