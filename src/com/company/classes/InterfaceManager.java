package com.company.classes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class InterfaceManager {

    private List<MyInterface> interfaces;

    public InterfaceManager(List<MyInterface> interfaces) {
        this.interfaces = interfaces;
    }

    public void listInterfacesForCurrentTimestamp(List<MyInterface> rules){

        long time = System.currentTimeMillis();
        Timestamp currentTimestamp = new Timestamp(time);

        rules.forEach(r -> {
                    if(currentTimestamp.after(r.getFrom()) && currentTimestamp.before(r.getTo())){
                        System.out.println(r.getInterfaceDetails().getName());
                    }
                }
        );
    }

    public List<String> checkTransfer (int noOfFiles, String from, String to){

        List<String> result = new ArrayList<>();

        long time = System.currentTimeMillis();
        Timestamp currentTimestamp = new Timestamp(time);

        String date = currentTimestamp.toString();
        String[] splitDate = date.split(" ");

        Timestamp fromTime = Timestamp.valueOf(splitDate[0]+ " " + from+":00.000");
        Timestamp toTime = Timestamp.valueOf(splitDate[0]+ " " + to+":00.000");

        interfaces.stream().filter(MyInterface::getActive).forEach(r -> {
                    if(fromTime.after(r.getFrom()) && toTime.before(r.getTo()) && isFollowingTransferRate(r,noOfFiles)){
                        result.add(r.getInterfaceDetails().getName());
                    }
                }
        );

        return result;
    }


    private boolean isFollowingTransferRate(MyInterface myInterface, int noFiles){

        switch (myInterface.getRelation()){

            case "==": return noFiles == myInterface.getExpected();

            case "<=": return noFiles <= myInterface.getExpected();

            case ">=": return noFiles >= myInterface.getExpected();

            default: return false;
        }

    }

    public List<MyInterface> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<MyInterface> interfaces) {
        this.interfaces = interfaces;
    }
}
