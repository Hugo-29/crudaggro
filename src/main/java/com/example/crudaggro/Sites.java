package com.example.crudaggro;

public class Sites {

    private Integer site_id;
    private String  villes;

    public Sites(Integer site_id, String villes) {
        this.site_id = site_id;
        this.villes = villes;
    }

    public Integer getSite_id() {
        return site_id;
    }

    public void setSite_id(Integer site_id) {
        this.site_id = site_id;
    }

    public String getVilles() {
        return villes;
    }

    public void setVilles(String villes) {
        this.villes = villes;
    }
}
