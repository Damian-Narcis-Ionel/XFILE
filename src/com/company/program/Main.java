package com.company.program;

import com.company.classes.InterfaceDetails;
import com.company.classes.InterfaceManager;
import com.company.classes.JsonReader;
import com.company.classes.MyInterface;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    //Sending a json with UTF8-BOM encoding should be a crime
    //change file's encoding to UTF-8 for this program to work, ty
    public static void main(String[] args) throws IOException, ParseException {


        String file = "src/expected.json";

        List<MyInterface> rules = JsonReader.readJson(file);
        List<InterfaceDetails> interfaces = rules.stream().map(MyInterface::getInterfaceDetails).collect(Collectors.toList());

        InterfaceManager interfaceManager = new InterfaceManager(rules);

        //2
        System.out.println("2.");
        rules.stream().sorted(Comparator.comparingLong(MyInterface::getPriority)).forEach(r -> System.out.println(r.getInterfaceDetails().getName()));

        //3
        System.out.println("3.");
        interfaceManager.listInterfacesForCurrentTimestamp(rules);

        //4
        System.out.println("4.");
        List<String> result = interfaceManager.checkTransfer(4, "13:00", "15:00");
        rules.stream().filter(MyInterface::getActive).forEach(
                r->{
                    if(result.contains(r.getInterfaceDetails().getName())){
                        System.out.println(r.getInterfaceDetails().getName()+"-success");
                    }else{
                        System.out.println(r.getInterfaceDetails().getName()+"-error");
                    }

                }
        );

    }
}
