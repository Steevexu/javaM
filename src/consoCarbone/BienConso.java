package consoCarbone;

public class BienConso extends ConsoCarbone{
    // Attributs
    private double montant;

    // Constructeur
    public BienConso(double montant){
        super(); // pour l'id
        this.montant = montant;
        this.calc_impact();
    }

    // Getter
    public double getMontant(){
        return montant;
    }
    // Setter
    public void setMontant(double montant){
        this.montant = montant;
    }

    // Calcul de l'impact
    @Override
    public double calc_impact() {
        return this.montant * 1750;
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
        return "BienConso [id = " + id + ", montant = " + montant + ", impact = " + calc_impact() +  "]";
    }

    // Méthode de classe Moyenne_BienConso
    public static void Moyenne_BienConso(){
        System.out.println("Empreinte carbone moyenne d'un français par rapport à la Bonne Consommation:");
        System.out.println("Habillement : 763 Kg eq CO2/an");
        System.out.println("Achat et usages Internet et technologies : 1 180 Kg eq CO2/an");
        System.out.println("Autres Biens et Services : 682 Kg eq CO2/an");
    }

}
