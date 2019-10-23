package org.o7planning.locationVehicule.controller;

import org.o7planning.locationVehicule.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


public class ApiController {

    private RestTemplate restTemplate = new RestTemplate();

    public Vehicule[] getVehicules() {
        return restTemplate.getForObject("http://localhost:8081/vehiculeList", Vehicule[].class);
    }

    public Vehicule getVehiculeById(int id){
        return restTemplate.getForObject("http://localhost:8081/vehicule/"+id, Vehicule.class);
    }

    public Vehicule postVehicule(Vehicule vehicule){
        return restTemplate.postForObject("http://localhost:8081/addNew", vehicule, Vehicule.class);
    }

    
}
