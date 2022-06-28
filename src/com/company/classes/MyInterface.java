package com.company.classes;

import java.sql.Timestamp;

//I have no idea how to name this class tbh
public class MyInterface implements Comparable<MyInterface>{

    private Long id;
    private InterfaceDetails interfaceDetails;
    private Long priority;
    private Boolean active;
    private Timestamp from;
    private Timestamp to;
    private Long expected;
    private String relation;

    public MyInterface(Long id, InterfaceDetails anInterface, Long priority, Boolean active, String from, String to, Long expected, String relation) {

        long time = System.currentTimeMillis();
        Timestamp currentTimestamp = new Timestamp(time);

        String date = currentTimestamp.toString();
        String[] splitDate = date.split(" ");

        Timestamp interfaceTimeFrom = Timestamp.valueOf(splitDate[0]+ " " + from);
        Timestamp interfaceTimeTo = Timestamp.valueOf(splitDate[0]+ " " + to);

        this.id = id;
        this.interfaceDetails = anInterface;
        this.priority = priority;
        this.active = active;
        this.from = interfaceTimeFrom;
        this.to = interfaceTimeTo;
        this.expected = expected;
        this.relation = relation;
    }

    public MyInterface() {}

    public MyInterface(String name, boolean active, String from, String to, Long expected, String relation) {

        long time = System.currentTimeMillis();
        Timestamp currentTimestamp = new Timestamp(time);

        String date = currentTimestamp.toString();
        String[] splitDate = date.split(" ");

        Timestamp interfaceTimeFrom = Timestamp.valueOf(splitDate[0]+ " " + from);
        Timestamp interfaceTimeTo = Timestamp.valueOf(splitDate[0]+ " " + to);

        this.interfaceDetails =new InterfaceDetails();
        this.interfaceDetails.setName(name);
        this.active = active;
        this.from = interfaceTimeFrom;
        this.to = interfaceTimeTo;
        this.relation = relation;
        this.expected=expected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InterfaceDetails getInterfaceDetails() {
        return interfaceDetails;
    }

    public void setInterfaceDetails(InterfaceDetails interfaceDetails) {
        this.interfaceDetails = interfaceDetails;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }

    public Long getExpected() {
        return expected;
    }

    public void setExpected(Long expected) {
        this.expected = expected;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", anInterface=" + interfaceDetails +
                ", priority=" + priority +
                ", active=" + active +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", expected=" + expected +
                ", relation='" + relation + '\'' +
                '}';
    }

    @Override
    public int compareTo(MyInterface o) {
        return this.getPriority().compareTo(o.getPriority());
    }
}
