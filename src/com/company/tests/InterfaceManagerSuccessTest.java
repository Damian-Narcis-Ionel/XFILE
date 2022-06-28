package com.company.tests;

import com.company.classes.InterfaceManager;
import com.company.classes.MyInterface;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InterfaceManagerSuccessTest {

    @Test
    public void checkTransfer() {

            List<MyInterface> interfaces = new ArrayList<>();
            interfaces.add(new MyInterface("interface_1", true, "00:30:00", "17:00:00", 17L,"<="));
            interfaces.add(new MyInterface("interface_2", true, "12:30:00", "14:30:00", 12L,"<="));
            interfaces.add(new MyInterface("interface_3", true, "00:30:00", "17:00:00", 17L,"=="));
            interfaces.add(new MyInterface("interface_4", false, "00:30:00", "17:00:00", 17L,"<="));

            List<String> result = new ArrayList<>();
            result.add("interface_1");

            InterfaceManager interfaceManager = new InterfaceManager(interfaces);

            assertEquals(interfaceManager.checkTransfer(4, "13:00", "15:00"), result);
    }
}