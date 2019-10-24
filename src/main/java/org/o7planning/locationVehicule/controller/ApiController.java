package org.o7planning.locationVehicule.controller;

import org.o7planning.locationVehicule.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ApiController {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    public List<Vehicule> getVehicules() {

        Vehicule[] vehicules = restTemplate.getForObject("http://localhost:8081/vehiculeList", Vehicule[].class);

        return new ArrayList<>(Arrays.asList(vehicules));
    }

    public Vehicule getVehiculeById(int id){
        return restTemplate.getForObject("http://localhost:8081/vehicule/"+id, Vehicule.class);
    }

    public Vehicule postVehicule(Vehicule vehicule){
        return restTemplate.postForObject("http://localhost:8081/addNew", vehicule, Vehicule.class);
    }

    public void deleteVehicule(int id) {
        restTemplate.delete("http://localhost:8081/deleteVehicule/"+id);
    }
    
}
