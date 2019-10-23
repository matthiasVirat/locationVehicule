package org.o7planning.locationVehicule.controller;

import org.o7planning.locationVehicule.form.VehiculeForm;
import org.o7planning.locationVehicule.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    //    private List getVehicules() {
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject("http://localhost:8081/vehiculeList", List.class);
//    }



    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    // Permet de définir les routes, la méthode associé et le traitement des datas à renvoyer au template.
    // Injection du message d'accueil dans index.html
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message", message);
        return "index";
    }

    // Injection de la liste des véhicules dans vehiculeList.html
    @RequestMapping(value = {"/vehiculeList"}, method = RequestMethod.GET)
    public String vehiculeList(Model model){
        ApiController apiController = new ApiController();
        model.addAttribute("vehicules", apiController.getVehicules());
        return "vehiculeList";
    }
//    @RequestMapping(value = {"/vehicule/{id}"}, method = RequestMethod.GET)
//    public Vehicule vehiculeById(Model model, @PathVariable int id) {
//        ApiController apiController = new ApiController();
//        return
//    }

    // Injection du contenu du formulaire d'ajout de véhicule dans addVehicule.html
//    @RequestMapping(value = {"/addVehicule"}, method = RequestMethod.GET)
//    public String showAddVehiculeForm(Model model){
//        VehiculeForm vehiculeForm = new VehiculeForm();
//        model.addAttribute("vehiculeForm", vehiculeForm);
//        return "addVehicule";
//    }

    // Injection des données issues du formulaire dans la liste de véhicules
//    @RequestMapping(value = {"/addVehicule"}, method = RequestMethod.POST)
//    public String saveVehicule(Model model, @ModelAttribute("vehiculeForm") VehiculeForm vehiculeForm){
//        int id        = vehiculeForm.getId();
//        String marque = vehiculeForm.getMarque();
//        String modele = vehiculeForm.getModele();
//
//        if (id != 0 && marque != null && marque.length() > 0 && model != null && modele.length() > 0){
//            Vehicule vehicule = new Vehicule(id, marque, modele);
//            vehicules.add(vehicule);
//            return "redirect:/vehiculeList";
//        } else {
//            model.addAttribute("errorMessage", errorMessage);
//            return "addVehicule";
//        }
//    }
}