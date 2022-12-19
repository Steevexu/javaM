package consoCarbone;

public class Transport extends ConsoCarbone{
    // Attributs
    public boolean possede;
    public Taille taille;
    public int kilomAnnee;
    private int amortissement;

    // Constructeur
    public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement){
        super(); // pour l'id
        this.possede = possede;
        this.taille = taille;
        this.kilomAnnee = kilomAnnee;
        this.amortissement = amortissement;
        this.calc_impact();
    }

    // Getter
    public boolean isPossede(){
        return possede;
    }

    public Taille getTaille(){
        return taille;
    }

    public int getKilomAnnee(){
        return kilomAnnee;
    }

    public int getamortissement(){
        return amortissement;
    }

    // Setter
    public void setPossede(boolean possede){
        this.possede = possede;
    }

    public void setTaille(Taille taille){
        this.taille = taille;
    }
    public void setKilomAnnee(int kilomAnnee){
        this.kilomAnnee = kilomAnnee;
    }
    public void setamortissement(int amortissement){
        this.amortissement = amortissement;
    }

    // Calcul de l'impact
    @Override
    public double calc_impact() {
        if (!this.possede)
            this.impact = 0;
        else
            this.impact = this.kilomAnnee * 1.93 * 0.0001 + this.taille.depense / this.amortissement;
        return this.impact;
    }

    // Pour comparer les impact
    // return = -1 si notre "this impact" est plus petit que "var.impact"
    // 0 si ils sont égaux
    // 1 si "this impact" est plus grand que "var.impact"
    @Override
    public int compareTo(ConsoCarbone var){
        return(int)(this.impact - var.impact);
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Transport [id = " + id +  ", Possede = " + possede + ", Taille = " + taille + ", KilomAnnee = " + kilomAnnee + ", Amortissement = " + amortissement + ", impact = " + calc_impact() + "]";
    }

    // Méthode de classe Moyenne_Transport
    public static void Moyenne_Transport(){
        System.out.println("Empreinte carbone moyenne d'un français par rapport au Transport:");
        System.out.println("Train et bus : 85 Kg eq CO2/an");
        System.out.println("Fret et messagerie : 383 Kg eq CO2/an");
        System.out.println("Avions  : 480 Kg eq CO2/an");
        System.out.println("Voiture : 1972 Kg eq CO2/an");
    }

}
