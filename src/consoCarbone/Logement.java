package consoCarbone;

public class Logement extends ConsoCarbone{
    // Attributs
    private int superficie; // la superficie du logement en m²
    private CE ce; // la classe énergétique du logement

    // Constructeur
    public Logement(int superficie, CE ce) {
        super(); // pour l'id
        this.superficie = superficie;
        this.ce = ce;
        this.calc_impact();
    }

    // Getter
    public int getsuperficie(){
        return superficie;
    }

    public CE getce(){
        return ce;
    }

    // Setter
    public void setsuperficie(int superficie){
        this.superficie = superficie;
    }

    public void setce(CE ce){
        this.ce = ce;
    }

    // Calcul de l'impact
    @Override
    public double calc_impact(){
        switch(ce){
            case A:
                return superficie * 0.005;
            case B:
                return superficie * 0.01;
            case C:
                return superficie * 0.02;
            case D:
                return superficie * 0.035;
            case E:
                return superficie * 0.055;
            case F:
                return superficie * 0.08;
            case G:
                return superficie * 0.1;
        }
        return -1;
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
        return "Logement [ id = " + id + ", superficie = " + superficie + ", classe Energétique = " + ce + ", impact = " + calc_impact() + "]";
    }

    // Méthode de classe Moyenne_Logement
    public static void Moyenne_Logement(){
        System.out.println("Empreinte carbone moyenne d'un français par rapport au logement :");
        System.out.println("Equipements des logements : 335 Kg eq CO2/an");
        System.out.println("Construction et gros entretien : 675 Kg eq CO2/an");
        System.out.println("Energie et utilités : 1696 Kg eq CO2/an");
    }

}
