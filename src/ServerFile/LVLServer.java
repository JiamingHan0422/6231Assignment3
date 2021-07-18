package ServerFile;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import javax.xml.ws.Endpoint;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.RemoteException;

public class LVLServer {


    public static void main(String args[]) throws RemoteException {

        WebServerImpl serverImpl = new WebServerImpl("LVL");
        Endpoint LVLendpoint = Endpoint.publish("http://localhost:7052/LVLServer", serverImpl);
        System.out.println(LVLendpoint.isPublished());

        new Thread(new Runnable() {
            @Override
            public void run() {
                serverImpl.UDPServer(5052);
            }
        }).start();
    }

}
