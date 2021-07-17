package ServerFile;

import javax.xml.ws.Endpoint;

public class PublishWS {
    public static void main(String[] args) {
        Endpoint DDOendpoint = Endpoint.publish("http://localhost:6231/DDOServer", new WebServerImpl());
        Endpoint MTLendpoint = Endpoint.publish("http://localhost:6241/MTLServer", new WebServerImpl());
        Endpoint LVLendpoint = Endpoint.publish("http://localhost:6251/LVLServer", new WebServerImpl());

        System.out.println(DDOendpoint.isPublished());
        System.out.println(MTLendpoint.isPublished());
        System.out.println(LVLendpoint.isPublished());

    }
}
