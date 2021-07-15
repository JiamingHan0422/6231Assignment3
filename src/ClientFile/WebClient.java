package ClientFile;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class WebClient {
    public static void main(String[] args) throws MalformedURLException {
        URL DDOurl = new URL("http://localhost:6231/DDOServer?wsdl");
        URL MTLurl = new URL("http://localhost:6231/MTLServer?wsdl");
        URL LVLurl = new URL("http://localhost:6231/LVLServer?wsdl");

        //这个到时候需要分成三个，需要改一下URL
        QName DDOName = new QName("http://ServerFile","ServerFile");
        QName MTLName = new QName("http://ServerFile","ServerFile");
        QName LVLName = new QName("http://ServerFile","ServerFile");

        Service DDOservice = Service.create(DDOurl,DDOName);
        Service MTLservice = Service.create(MTLurl,MTLName);
        Service LVLservice = Service.create(LVLurl,LVLName);

        WebService DDowebService = DDOservice.getPort(WebService.class);
        WebService MTLwebService = MTLservice.getPort(WebService.class);
        WebService LVLwebService = LVLservice.getPort(WebService.class);

    }
}
