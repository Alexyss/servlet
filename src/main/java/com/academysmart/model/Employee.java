package com.academysmart.model;

public class Employee {
	//TODO implement model for employee
    private String name;
    private String family;
    private String email;
    private int idPerson;
//    private static AtomicInteger count = new AtomicInteger(0);
//    public Employee(){
//        count.incrementAndGet();
//        this.idPerson = count.get();
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
}
