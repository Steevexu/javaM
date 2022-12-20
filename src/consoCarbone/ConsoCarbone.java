package consoCarbone;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone>{
    private static int nb; // compteur de id
    protected int id; // ID
    protected double impact;

    //Constructeur
    public ConsoCarbone() {
        this.id = ++ConsoCarbone.nb;
    }

    // Getter
    public int getId(){
        return id;
    }

    public double getimpact(){
        return impact;
    }

    // Setter
    public void setId(int id){
        this.id = id;
    }

    public void setimpact(double impact){
        this.impact = impact;
    }

    // Abstract pour la fonction calc_impact
    public abstract double calc_impact();
}
