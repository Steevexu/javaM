package consoCarbone;

public class ServicesPublics extends ConsoCarbone{
    public static ServicesPublics instance;

    // design pattern Singleton
    public static ServicesPublics NewServicesPublics() {
        if (ServicesPublics.instance == null)
            ServicesPublics.instance = new ServicesPublics();
        return instance;
    }

    // Constructeur
    private ServicesPublics(){
        this.calc_impact();
    }

    // Calcul de l'impact
    @Override
    public double calc_impact(){
        return this.impact = 1.5 * 1750;
    }

    // Méthode compareTo pour comparer 2 instances
    @Override
    public int compareTo(ConsoCarbone var){
        return 0;
    }

    // Méthode toString
    @Override
    public String toString(){
        return "ServicesPublics [ id = " + id + ", impact = " + calc_impact() + "]";
    }

    // Méthode de classe Moyenne_ServicesPublics
    public static void Moyenne_ServicesPublics (){
        System.out.println("Empreinte carbone moyenne d'un français par rapport aux Services Publics :");
        System.out.println("Santé : 1489 Kg eq CO2/an");
    }

}
