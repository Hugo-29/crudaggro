package com.example.crudaggro;

public class Services {

    private Integer service_id;
    private String service;

    public Services(Integer service_id, String service) {
        this.service_id = service_id;
        this.service = service;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
