package user;

import consoCarbone.*;

public class Utilisateur {
    // Instances
    private Alimentation alimentation;
    private BienConso bienConso;
    private Logement logement;
    private Transport transport;
    private ServicesPublics services;

    // Constructeur

    // Getter
    public Alimentation getAlimentation(){
        return alimentation;
    }

    public BienConso getBienConso(){
        return bienConso;
    }

    public Logement getLogement(){
        return logement;
    }

    public Transport getTransport(){
        return transport;
    }

    public ServicesPublics getServicesPublics(){
        return services;
    }

    // Setter
    public void setAlimentation(Alimentation alimentation){
        this.alimentation = alimentation;
    }

    public void setBienConso(BienConso bienConso){
        this.bienConso = bienConso;
    }

    public void setLogement(Logement logement){
        this.logement = logement;
    }

    public void setServicesPublics(ServicesPublics services){
        this.services = services;
    }

    public void setTransport(Transport transport){
        this.transport = transport;
    }

    // Méthode CalculerEmpreinte qui calcule l'empreinte carbone de l'utilisateur
    public double calculerEmpreinte(){
        this.alimentation.calc_impact();
        this.bienConso.calc_impact();
        this.logement.calc_impact();
        this.services.calc_impact();
        this.transport.calc_impact();
        return this.alimentation.calc_impact() +
                this.bienConso.calc_impact() +
                this.logement.calc_impact() +
                this.services.calc_impact() +
                this.transport.calc_impact();
    }

    // Méthode detaillerEmpreinte
    public void detaillerEmpreinte(){
        this.calculerEmpreinte();
        String de1 = "Alimentation [ impact : " + this.alimentation.calc_impact() + "]\n" +
                "Logement [ impact : " + this.logement.calc_impact() + "]\n" +
                "Services Publics [ impact : " + this.services.calc_impact() + "]\n" +
                "Transport [ impact : " + this.transport.calc_impact() + "]\n";
        System.out.println(de1);
    }
}




