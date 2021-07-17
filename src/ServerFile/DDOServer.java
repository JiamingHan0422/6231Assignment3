package ServerFile;

import javax.xml.ws.Endpoint;
import java.rmi.RemoteException;

//DDOServer object
public class DDOServer {
    public static void main(String args[]) throws RemoteException {

        Endpoint DDOendpoint = Endpoint.publish("http://localhost:5051/DDOServer", new WebServerImpl("DDO"));
        System.out.println(DDOendpoint.isPublished());

    }
}
