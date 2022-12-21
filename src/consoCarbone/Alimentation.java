package consoCarbone;

public class Alimentation extends ConsoCarbone{
    // Attributs
    private static double C1 = 8.0; // Constante n°1
    private static double C2 = 1.6; // Constante n°2
    private static double C3 = 0.9; // Constante n°3
    private double txBoeuf;
    private double txVege;

    // Constructeur
    public Alimentation(double txBoeuf, double txVege) {
        super(); // pour l'id
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
        this.calc_impact();
    }


    // Getter
    public double gettxBoeuf() {
        return txBoeuf;
    }

    public double gettxVege() {
        return txVege;
    }

    // Setter
    public void settxBoeuf(double txBoeuf) {
        this.txBoeuf = txBoeuf;
    }

    public void settxVege(double txVege) {
        this.txVege = txVege;
    }

    // Calcul de l'impact
    @Override
    public double calc_impact() {
        return Alimentation.C1 * txBoeuf + Alimentation.C2 * (1 - txVege - txBoeuf) + Alimentation.C3 * txVege;
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
    public String toString(){
        return "Alimentation [ id = " + id + ", txBoeuf = " + txBoeuf + ", txVege = " + txVege + ", impact = " + calc_impact() + "]";
    }

    // Méthode de classe Moyenne_Alimentation
    public static void Moyenne_Alimentation(){
        System.out.println("Empreinte carbone moyenne d'un français par rapport à l'alimentation :");
        System.out.println("Boissons : 263 Kg eq CO2/an");
        System.out.println("Produits laitier et oeufs : 408 Kg eq CO2/an");
        System.out.println("Viandes et poissons : 1 144 Kg eq CO2/an");
        System.out.println("Autres : 538 Kg eq CO2/an");
    }

}