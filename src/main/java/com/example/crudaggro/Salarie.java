package com.example.crudaggro;

public class Salarie {

    private Integer salarie_id;
    private String nom;
    private String prenom;
    private String fixe;
    private String portable;
    private String email;

    public Salarie(Integer salarie_id, String nom, String prenom, String fixe, String portable,String email) {
        this.salarie_id = salarie_id;
        this.nom = nom;
        this.prenom = prenom;
        this.fixe = fixe;
        this.portable = portable;
        this.email= email;
    }

    public Integer getSalarie_id() {
        return salarie_id;
    }

    public void setSalarie_id(Integer salarie_id) {
        this.salarie_id = salarie_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFixe() {
        return fixe;
    }

    public void setFixe(String fixe) {
        this.fixe = fixe;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public void setEmail(String email){this.email=email;}

    public String getEmail() {
        return email;
    }
}
