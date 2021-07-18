package ServerFile;

import javax.xml.ws.Endpoint;
import java.rmi.RemoteException;

//MTLServer object
public class MTLServer {

    public static void main(String args[]) throws RemoteException {

        WebServerImpl serverImpl = new WebServerImpl("MTL");
        Endpoint MTLendpoint = Endpoint.publish("http://localhost:7053/MTLServer", serverImpl);
        System.out.println(MTLendpoint.isPublished());

        new Thread(new Runnable() {
            @Override
            public void run() {
                serverImpl.UDPServer(5053);
            }
        }).start();

    }

}
