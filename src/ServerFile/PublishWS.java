package ServerFile;

import javax.xml.ws.Endpoint;
import java.rmi.RemoteException;

public class PublishWS {
    public static void main(String[] args) throws RemoteException {
        Endpoint DDOendpoint = Endpoint.publish("http://localhost:7051/DDOServer", new WebServerImpl());
        Endpoint MTLendpoint = Endpoint.publish("http://localhost:7053/MTLServer", new WebServerImpl());
        Endpoint LVLendpoint = Endpoint.publish("http://localhost:7052/LVLServer", new WebServerImpl());

        System.out.println(DDOendpoint.isPublished());
        System.out.println(MTLendpoint.isPublished());
        System.out.println(LVLendpoint.isPublished());

    }
}
