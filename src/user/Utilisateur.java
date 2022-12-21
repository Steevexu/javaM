package user;

import consoCarbone.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilisateur {
    // Instances
    private Alimentation alimentation;
    private BienConso bienConso;
    private ServicesPublics services;

    private List<Logement> listLogement;
    private List<Transport> listTransport;

    private ArrayList<ConsoCarbone> liste;

    // Constructeur
    public Utilisateur(){
        this.alimentation = new Alimentation(0,0);
        this.bienConso = new BienConso(0);
        this.services = ServicesPublics.NewServicesPublics();
        this.listTransport = new ArrayList<>();
        this.listLogement = new ArrayList<>();
        this.liste = new ArrayList<>();
        this.liste.add(alimentation);
        this.liste.add(bienConso);
        this.liste.add(services);
    }

    public Utilisateur(double tauxBoeuf, double tauxVege,int montant, int superficie, char niveauEnergie,
                       char taille, int kilom, int amort){
        this.alimentation = new Alimentation(tauxBoeuf,tauxVege);
        this.bienConso = new BienConso(montant);
        this.listLogement = new ArrayList<>();
        this.listTransport = new ArrayList<>();
        this.listLogement.add(this.getLogement(superficie,niveauEnergie));
        this.listTransport.add(this.getTransport(taille,kilom,amort));
    }

    // Méthode pour récupérer les valeurs de logement et transport
    public Logement getLogement(int superficie, char niveauEnergie){
        switch(niveauEnergie){
            case 'A' -> {return new Logement(superficie,CE.A);}
            case 'B' -> {return new Logement(superficie,CE.B);}
            case 'C' -> {return new Logement(superficie,CE.C);}
            case 'D' -> {return new Logement(superficie,CE.D);}
            case 'E' -> {return new Logement(superficie,CE.E);}
            case 'F' -> {return new Logement(superficie,CE.F);}
            case 'G' -> {return new Logement(superficie,CE.G);}
        }
        return null;
    }

    public Transport getTransport(char taille, int kilom, int amort){
        switch (taille){
            case 'P' -> {return new Transport(true,Taille.P, kilom, amort);}
            case 'G' -> {return new Transport(true,Taille.G, kilom, amort);}
        }
        return null;
    }

    // Setter
    public void setAlimentation(double txBoeuf, double txVege){
        this.alimentation.settxBoeuf(txBoeuf);
        this.alimentation.settxVege(txVege);
    }

    public void setBienConso(int montant){
        this.bienConso.setMontant(montant);
    }

    public void setAlimentation(Alimentation alimentation){
        this.alimentation = alimentation;
    }
    public void setBienConso(BienConso bienConso){
        this.bienConso = bienConso;
    }

    public void setServices(ServicesPublics services){
        this.services = services;
    }
    // Méthodes addlogement et addtransport
    public void addLogement(Logement logement){
        this.listLogement.add(logement);
    }

    public void addTransport(Transport transport){
        this.listTransport.add(transport);
    }

    // Méthode CalculerEmpreinte qui calcule l'empreinte carbone de l'utilisateur
    public double calculerEmpreinte(){
        if(this.listLogement.size() != 0)
            for(Logement logement : this.listLogement)
                logement.calc_impact();
        if (this.listTransport.size() != 0)
            for(Transport transport : this.listTransport)
                if (transport.isPossede())
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

    // Méthode Add_Liste pour rajouter les listes logement et transport
    public void add_liste(){
        if(! listTransport.isEmpty())
            for(Transport transport : listTransport)
                liste.add(transport);
        if(! listLogement.isEmpty())
            for(Logement logement : listLogement)
                liste.add(logement);
    }

    // Méthode Ordonner les consommations carbone de l'utilisateur
    public void Ordonner(){
        Collections.sort(liste);
        System.out.println(liste);
        String recommandations = "Pour obtenir un mode de vie plus durable :\n";
        System.out.println(recommandations + "- isolez votre logement, éteignez vos appareils non utilisés, réduisez un maximum votre consommation énergétique\n" +
                "- réduisez vos dépenses en biens de consommation\n" +
                "- Utilisez les transport en communs afin de limiter la consommation de carburant, pour les trajets court, déplacez vous à pied ou en vélo\n");
    }
    // Méthodes pour récuperer l'empreinte carbone selon les domaines
    //public double calc_impact_alimentation() {
    //    return this.alimentation.calc_impact();
    //}
    //public double calc_impact_bienConso() {
    //    return this.bienConso.calc_impact();
    //}
    //public double calc_impact_services() {
    //    return this.services.calc_impact();
    //}
    //public double calc_impact_logement() {
    //    return this.getImpactLogement();
    //}
    //public double calc_impact_transport() {
    //    return this.getImpactTransport();
    //}


}




