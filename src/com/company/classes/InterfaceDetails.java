package com.company.classes;

public class InterfaceDetails {

    private String name;
    private String desc;

    public InterfaceDetails(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public InterfaceDetails() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Interface{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

}
