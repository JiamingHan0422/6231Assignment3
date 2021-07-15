package ServerFile;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "ServerFile.WebServerInterface",
        serviceName = "ServerFile",
        portName = "ServerFilePort",
        targetNamespace = "http://ServerFile")

public class WebServerImpl {

    public boolean createTRecord(String managerID, String firstName, String lastName, String Address,
                                 String Phone, String Specialization, String Location) throws java.rmi.RemoteException {
        return false;
    }


    public boolean createSRecord(String managerID, String firstName, String lastName, String CoursesRegistered,
                                 String Status, String StatusDate) throws java.rmi.RemoteException {
        return false;
    }


    public boolean editRecord(String managerID, String recordID, String fieldName, String newValue) throws java.rmi.RemoteException {
        return false;
    }


    public boolean printRecord(String ManagerID) throws java.rmi.RemoteException {
        return false;
    }


    public String getRecordCounts() throws java.rmi.RemoteException {
        return null;
    }

}
