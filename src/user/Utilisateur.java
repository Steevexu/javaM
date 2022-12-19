package user;

import consoCarbone.*;

import java.util.*;
import java.util.stream.Collectors;

public class Utilisateur {
    // Instances
    private Alimentation alimentation;
    private BienConso bienConso;
    private ServicesPublics services;

    private List<Logement> listLogement;
    private List<Transport> listTransport;


    // Constructeur
    public Utilisateur(){
        this.listTransport = new ArrayList<>();
        this.listLogement = new ArrayList<>();
    }

    // Setter
    public void setAlimentation(Alimentation alimentation){
        this.alimentation = alimentation;
    }

    public void setBienConso(BienConso bienConso){
        this.bienConso = bienConso;
    }

    public void setServices(ServicesPublics services){
        this.services = services;
    }

    public void addLogement(Logement logement){
        this.listLogement.add(logement);
    }

    public void addTransport(Transport transport){
        this.listTransport.add(transport);
    }

    // Méthode CalculerEmpreinte qui calcule l'empreinte carbone de l'utilisateur
    public double calculerEmpreinte(){
        for(Logement logement : listLogement)
            logement.calc_impact();
        for(Transport transport : listTransport)
            transport.calc_impact();
        this.alimentation.calc_impact();
        this.bienConso.calc_impact();
        this.services.calc_impact();
        return this.alimentation.calc_impact() +
                this.bienConso.calc_impact() +
                this.services.calc_impact() +
                this.getImpactLogement() +
                this.getImpactTransport();
    }

    // Fonction pour avoir l'impact sur les logements
    private double getImpactLogement() {
        return this.listLogement.stream().mapToDouble(ConsoCarbone::calc_impact).sum();
    }

    // Fonction pour avoir l'impact sur les Transports
    private double getImpactTransport() {
        return this.listTransport.stream().mapToDouble(ConsoCarbone::calc_impact).sum();
    }

    // Méthode detaillerEmpreinte
    public void detaillerEmpreinte(){
        calculerEmpreinte();
        String de1 = "Alimentation [ impact : " + alimentation.calc_impact() + "]\n" +
                "BienConso [ impact : " + bienConso.calc_impact() + "]\n" +
                "Services Publics [ impact : " + services.calc_impact() + "]\n" +
                "Logement [ impact : " +  getImpactLogement() + "]\n" +
                "Transport [ impact : " + getImpactTransport() + "]\n";
        System.out.println(de1);
    }

    // A revoir
    public void recommender(){
        HashMap<String,Double> map = new HashMap<>();

        map.put("alimentation",this.alimentation.calc_impact());
        map.put("bienConso",this.bienConso.calc_impact());
        map.put("services",this.services.calc_impact());
        map.put("logement",this.getImpactLogement());
        map.put("transport",this.getImpactTransport());

        map = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}




