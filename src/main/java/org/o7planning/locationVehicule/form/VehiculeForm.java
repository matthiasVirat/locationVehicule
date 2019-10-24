package org.o7planning.locationVehicule.form;

public class VehiculeForm {

    private String id;
    private String marque;
    private String modele;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Boolean validate(){
        return (marque != null && marque.length() > 0 && modele != null && modele.length() > 0);
    }
}
