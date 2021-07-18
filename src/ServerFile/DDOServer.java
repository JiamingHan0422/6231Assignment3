package ServerFile;

import javax.xml.ws.Endpoint;
import java.rmi.RemoteException;

//DDOServer object
public class DDOServer {
    public static void main(String args[]) throws RemoteException {

        WebServerImpl serverImpl = new WebServerImpl("DDO");
        Endpoint DDOendpoint = Endpoint.publish("http://localhost:7051/DDOServer", serverImpl);
        System.out.println(DDOendpoint.isPublished());

        new Thread(new Runnable() {
            @Override
            public void run() {
                serverImpl.UDPServer(5051);
            }
        }).start();

    }
}
