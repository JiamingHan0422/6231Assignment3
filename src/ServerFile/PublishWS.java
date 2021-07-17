package ServerFile;

import javax.xml.ws.Endpoint;
import java.rmi.RemoteException;

public class PublishWS {
    public static void main(String[] args) throws RemoteException {
        Endpoint DDOendpoint = Endpoint.publish("http://localhost:5051/DDOServer", new WebServerImpl("DDO"));
        Endpoint MTLendpoint = Endpoint.publish("http://localhost:5053/MTLServer", new WebServerImpl("MTL"));
        Endpoint LVLendpoint = Endpoint.publish("http://localhost:5052/LVLServer", new WebServerImpl("LVL"));

        System.out.println(DDOendpoint.isPublished());
        System.out.println(MTLendpoint.isPublished());
        System.out.println(LVLendpoint.isPublished());

    }
}
