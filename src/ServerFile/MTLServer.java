package ServerFile;

import javax.xml.ws.Endpoint;
import java.rmi.RemoteException;

//MTLServer object
public class MTLServer {

    public static void main(String args[]) throws RemoteException {

        Endpoint MTLendpoint = Endpoint.publish("http://localhost:5053/MTLServer", new WebServerImpl("MTL"));
        System.out.println(MTLendpoint.isPublished());

    }

}
