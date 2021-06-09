package com.codegym.model;

public class PersonService {
    int service_id;
    int person_id;

    public PersonService() {
    }

    public PersonService(int service_id, int person_id) {
        this.service_id = service_id;
        this.person_id = person_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
}
