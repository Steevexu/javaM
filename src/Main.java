import consoCarbone.*;
import user.Utilisateur;

public class Main {
    public static void main(String[] args) {
        // PARTIE LOGEMENT
        // Création de 2 objets de la classe Logement pour tester le programme
        System.out.println("Création d'un objet l1 logement : ");
        Logement l1 = new Logement(100,CE.G); // objet l1
        System.out.println(l1);
        System.out.println("Création d'un objet l2 logement : ");
        Logement l2 = new Logement(92,CE.B); // objet l2
        System.out.println(l2);
        Logement.Moyenne_Logement();
        System.out.println();

        // PARTIE ALIMENTATION
        // Création de 2 objets de la classe Alimentation pour tester le programme
        System.out.println("Création d'un objet a1 Alimentation :");
        Alimentation a1 = new Alimentation(0.8,0.9); // objet a1
        System.out.println(a1);
        System.out.println("Création d'un objet a2 Alimentation :");
        Alimentation a2 = new Alimentation(0.4,0.1); // objet a2
        System.out.println(a2);
        Alimentation.Moyenne_Alimentation();
        System.out.println();

        // PARTIE BIENCONSO
        // Création de 2 objets de la classe BienConso pour tester le programme
        System.out.println("Création d'un objet b1 BienConso :");
        BienConso b1 = new BienConso(10); // objet b1
        System.out.println(b1);
        System.out.println("Création d'un objet b2 BienConso :");
        BienConso b2 = new BienConso(999); // objet b2
        System.out.println(b2);
        BienConso.Moyenne_BienConso();
        System.out.println();

        // PARTIE TRANSPORT
        // Création de 2 objets de la classe Transport pour tester le programme
        System.out.println("Création d'un objet t1 Transport :");
        Transport t1 = new Transport(false,Taille.P,10,5); // objet t1
        System.out.println(t1);
        System.out.println("Création d'un objet t2 Transport :");
        Transport t2 = new Transport(true,Taille.G,100,9); // objet t2
        System.out.println(t2);
        Transport.Moyenne_Transport();
        System.out.println();

        // PARTIE SERVICES PUBLICS
        // Création de 1 objet de la classe ServicesPublics pour tester le programme
        System.out.println("Création d'un objet s1 ServicesPublics :");
        ServicesPublics s1 = ServicesPublics.NewServicesPublics(); // objet s1
        System.out.println(s1);
        ServicesPublics.Moyenne_ServicesPublics();
        System.out.println();

        // PARTIE UTILISATEUR
        // Création de 1 objet de la classe Utilisateur pour tester le programme
        System.out.println("Création d'un objet u1 Utilisateur :");
        System.out.println();
        System.out.println();
    }
}
