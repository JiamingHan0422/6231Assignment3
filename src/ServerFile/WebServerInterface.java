package ServerFile;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebServerInterface {

    @WebMethod
    public boolean createTRecord (String managerID, String firstName, String lastName, String Address,
                                  String Phone, String Specialization, String Location)throws java.rmi.RemoteException;

    @WebMethod
    public boolean createSRecord (String managerID, String firstName, String lastName, String CoursesRegistered,
                                  String Status, String StatusDate)throws java.rmi.RemoteException;

    @WebMethod
    public boolean editRecord (String managerID, String recordID, String fieldName, String newValue) throws java.rmi.RemoteException;

    @WebMethod
    public boolean printRecord (String ManagerID) throws java.rmi.RemoteException;
    @WebMethod
    boolean transferRecord (String managerID, String recordID, String remoteCenterServerName);

    @WebMethod
    public String getRecordCounts() throws java.rmi.RemoteException;

}
