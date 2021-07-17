package ClientFile;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

import ManagerFile.Manager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class WebClient {
    public static void main(String[] args) throws MalformedURLException, InvalidName, NotFound, CannotProceed {
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


        WebClient webClient = new WebClient();

        webClient.procedure();

        }




        public void procedure() throws CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound {
            while(true) {
                String ManagerID;
                int ManagerInput;
                boolean ManagerValid = false;

                Scanner ManagerScanner = new Scanner(System.in);
                System.out.println("Please input the ManagerID. Enter 0, if you want exit.");
                ManagerID = ManagerScanner.nextLine();
                ManagerID = ManagerID.toUpperCase();
                Manager manager = new Manager();
                manager.setManagerID(ManagerID);

                if (ManagerID.startsWith("MTL")) {
                    ManagerValid = true;
                    String name = "MTL";
                    //通过ORB拿到server实例化好的Creator类
                    creator = CreatorHelper.narrow(ncRef.resolve_str(name));

                } else if (ManagerID.startsWith("LVL")) {
                    ManagerValid = true;
                    String name = "LVL";
                    //通过ORB拿到server实例化好的Creator类
                    creator = CreatorHelper.narrow(ncRef.resolve_str(name));

                } else if (ManagerID.startsWith("DDO")) {
                    ManagerValid = true;
                    String name = "DDO";
                    //通过ORB拿到server实例化好的Creator类
                    creator = CreatorHelper.narrow(ncRef.resolve_str(name));

                }else{
                    System.out.println("ManagerID is invalid, please try again.");
                    ManagerValid = false;
                }

                if(ManagerID.equals("0")){
                    break;
                }
                // if the manager ID is valid, then user will have 6 option on the menu, using switch case to do the next operation based on user`s enter.
                if(ManagerValid) {
                    do {
                        int out = 1;
                        System.out.println("Welcome: " + ManagerID);
                        System.out.println("Please select the function.");
                        System.out.println(
                                "1.Create Teacher Record. " + "\n" +
                                        "2.Create Student Record." + "\n" +
                                        "3.Get Record Counts." + "\n" +
                                        "4. Edit Record." + "\n" +
                                        "5. Transfer Record." + "\n" +
                                        "6. Print Record." + "\n" +
                                        "0. EXIT");
                        ManagerInput = ManagerScanner.nextInt();

                        switch (ManagerInput) {
                            // terminal the program.
                            case 0:
                                out = 0;
                                break;

                            //create Teacher Record
                            case 1:
                                System.out.println("Please Create Teacher Record.");
                                System.out.println("Enter: firstName, lastName, address, phone, specialization, location(mtl,lvl,ddo) ");
                                String firstName = ManagerScanner.next();
                                String lastName = ManagerScanner.next();
                                String address = ManagerScanner.next();
                                String phone = ManagerScanner.next();
                                String specialization = ManagerScanner.next();

                                firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
                                lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

                                String location = ManagerScanner.next();
                                while (!(location.equals("mtl") || location.equals("lvl") || location.equals("ddo"))) {
                                    System.out.println("Location is invalid, please try again.(mtl,lvl,ddo)\n");
                                    location = ManagerScanner.next();
                                }

                                boolean result = creator.createTRecord(ManagerID, firstName, lastName, address, phone, specialization, location);
                                if (result) {
                                    System.out.println("success!");

                                    String writeInLog = "Create Teacher Record." + "\n" +
                                            "Name: " + firstName + " " + lastName + "\n" +
                                            "Address: " + address + " " + "\n" +
                                            "Phone: " + phone + " " + "\n" +
                                            "Specialization: " + specialization + " " + "\n" +
                                            "Location: " + location + " " + "\n" +
                                            "Time: " + getTime() + " " + "\n" + "\n";

                                    manager.writeLog(writeInLog);
                                } else {
                                    System.out.println("access deny.");
                                }
                                break;

                            //create Student Record
                            case 2:
                                System.out.println("Please Create Student Record.");
                                System.out.println("Enter: firstName, lastName, CoursesRegister, Status(active/inactive), StatusDate");
                                firstName = ManagerScanner.next();
                                lastName = ManagerScanner.next();
                                String CoursesRegister = ManagerScanner.next();
                                String Status = ManagerScanner.next();
                                while (!(Status.equals("active") || Status.equals("inactive"))) {
                                    System.out.println("Status is invalid, please try again.(active/inactive)\n");
                                    Status = ManagerScanner.next();
                                }
                                String StatusDate = ManagerScanner.next();

                                firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
                                lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

                                result = creator.createSRecord(ManagerID, firstName, lastName, CoursesRegister, Status, StatusDate);
                                if (result) {
                                    System.out.println("success!");

                                    String writeInLog = "Create Student Record." + "\n" +
                                            "Name: " + firstName + " " + lastName + "\n" +
                                            "CoursesRegister: " + CoursesRegister + " " + "\n" +
                                            "Status: " + Status + " " + "\n" +
                                            "StatusDate: " + StatusDate + " " + "\n" +
                                            "Time: " + getTime() + " " + "\n" + "\n";

                                    manager.writeLog(writeInLog);

                                } else {
                                    System.out.println("access deny.");
                                }
                                break;

                            // get record count
                            case 3:

                                System.out.println(creator.getRecordCounts());
                                break;

                            //edit record
                            case 4:
                                System.out.println("------------------------------------------------------");
                                System.out.println("Please Input the RecordID, fieldName and the newValue.");
                                System.out.println("------------------------------------------------------");
                                System.out.println("The Teacher Record: address, phone, specialization, location(mtl,lvl,ddo) can be changed");
                                System.out.println("------------------------------------------------------");
                                System.out.println("The Student Record: coursesregistered, status(active/inactive), statusdate can be changed");
                                System.out.println("------------------------------------------------------");
                                System.out.println("Enter: RecordID, fieldName, newValue,");
                                System.out.println("------------------------------------------------------");

                                String RecordID = ManagerScanner.next();
                                String fieldName = ManagerScanner.next();
                                String newValue = ManagerScanner.next();

                                result = creator.editRecord(ManagerID, RecordID, fieldName, newValue);
                                if (result) {
                                    System.out.println("success!");
                                    String writeInLog = "Edit Record." + "\n" +
                                            "RecordID: " + RecordID + "\n" +
                                            "fieldName: " + fieldName + " " + "\n" +
                                            "newValue: " + newValue + " " + "\n" +
                                            "Time: " + getTime() + " " + "\n" + "\n";

                                    manager.writeLog(writeInLog);

                                } else {
                                    System.out.println("access deny.");
                                }
                                break;

                            // transfer record
                            case 5:

                                System.out.println("Please input the RecordID which you want to transfer.");
                                String recordID = ManagerScanner.next();
                                System.out.println("Please input the remoteCenterServer which you want to transfer.");
                                String remoteCenterServer = ManagerScanner.next();

                                result = creator.transferRecord(ManagerID, recordID, remoteCenterServer);

                                if (result) {
                                    System.out.println("success!");
                                    String writeInLog = "Transfer Record." + "\n" +
                                            "RecordID: " + recordID + "\n" +
                                            "remoteCenterServer: " + remoteCenterServer + " " + "\n";

                                    manager.writeLog(writeInLog);

                                } else {
                                    System.out.println("access deny.");
                                }
                                break;

                            // print record
                            case 6:
                                result = creator.printRecord(ManagerID);
                                if (result) {
                                    System.out.println("success!");

                                } else {
                                    System.out.println("access deny.");
                                }
                                break;
                            default:
                                break;
                        }

                        if (out == 0) {
                            break;
                        }
                    } while (true);
                }

            }
        }

        public static String getTime(){
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String time = date.toString();
            return time;
        }



    }
}
