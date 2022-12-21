package consoCarbone;

public enum Taille {
    P(4.2),G(19);

    public double depense;

    // Constructeur
    private Taille(double taille_vehicule) {
        this.depense = taille_vehicule * 1750;
    }
}
