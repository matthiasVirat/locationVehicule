package org.o7planning.locationVehicule.controller;

import org.o7planning.locationVehicule.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//@RestController
public class ApiController {


    @Autowired
    private RestTemplate restTemplate;

    List<Vehicule> getVehicules() {
        Vehicule[] vehicules = restTemplate.getForObject("http://localhost:8081/vehiculeList", Vehicule[].class);
        return new ArrayList<>(Arrays.asList(vehicules));
    }

    List<Vehicule> getVehiculesOrdered(String critere, String ordre) {
        Vehicule[] vehicules = restTemplate.getForObject("http://spring-boot-thymeleaf/vehiculeList/"+critere+"/"+ordre, Vehicule[].class);
        return new ArrayList<>(Arrays.asList(vehicules));
    }

    Vehicule getVehiculeById(int id){
        return restTemplate.getForObject("http://spring-boot-thymeleaf/vehicule/"+id, Vehicule.class);
    }

    Vehicule postVehicule(Vehicule vehicule){
        return restTemplate.postForObject("http://spring-boot-thymeleaf/addNew", vehicule, Vehicule.class);
    }

    void deleteVehicule(int id) {
        restTemplate.delete("http://spring-boot-thymeleaf/deleteVehicule/"+id);
    }

    void updateVehicule(Vehicule vehicule) {
        restTemplate.put("http://spring-boot-thymeleaf/updateVehicule", vehicule);
    }

}
