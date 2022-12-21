import consoCarbone.*;
import user.Utilisateur;

public class Main {
    public static void main(String[] args) {
        // PARTIE LOGEMENT
        // Création de 2 objets de la classe Logement pour tester le programme
        System.out.println("Création d'un objet l1 logement : ");
        // ----------------------------------------------------------------------------------------------------------
        Logement l1 = new Logement(100,CE.G); // objet l1 <------------------------ A MODIFIER
        // ----------------------------------------------------------------------------------------------------------
        System.out.println(l1);
        System.out.println("Création d'un objet l2 logement : ");
        Logement l2 = new Logement(92,CE.B); // objet l2
        System.out.println(l2);
        Logement.Moyenne_Logement();
        System.out.println();

        // PARTIE ALIMENTATION
        // Création de 2 objets de la classe Alimentation pour tester le programme
        System.out.println("Création d'un objet a1 Alimentation :");
        // ----------------------------------------------------------------------------------------------------------
        Alimentation a1 = new Alimentation(0.9,0.1); // objet a1 <------------------------ A MODIFIER
        // ----------------------------------------------------------------------------------------------------------
        System.out.println(a1);
        System.out.println("Création d'un objet a2 Alimentation :");
        Alimentation a2 = new Alimentation(0.4,0.1); // objet a2
        System.out.println(a2);
        Alimentation.Moyenne_Alimentation();
        System.out.println();

        // PARTIE BIENCONSO
        // Création de 2 objets de la classe BienConso pour tester le programme
        System.out.println("Création d'un objet b1 BienConso :");
        // ----------------------------------------------------------------------------------------------------------
        BienConso b1 = new BienConso(10); // objet b1 <------------------------ A MODIFIER
        // ----------------------------------------------------------------------------------------------------------
        System.out.println(b1);
        System.out.println("Création d'un objet b2 BienConso :");
        BienConso b2 = new BienConso(999); // objet b2
        System.out.println(b2);
        BienConso.Moyenne_BienConso();
        System.out.println();

        // PARTIE TRANSPORT
        // Création de 2 objets de la classe Transport pour tester le programme
        System.out.println("Création d'un objet t1 Transport :");
        // ----------------------------------------------------------------------------------------------------------
        Transport t1 = new Transport(false,Taille.P,10,5); // objet t1<----- A MODIFIER
        // ----------------------------------------------------------------------------------------------------------
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
        Utilisateur u1 = new Utilisateur();
        u1.addLogement(l1); // ajout des données dans notre listLogement
        u1.addTransport(t1); // ajout des données dans notre listTransport
        u1.add_liste(); // ajout des listes logement et transport dans notre liste principal
        System.out.println(u1.calculerEmpreinte()); // Utilisation de la méthode calculerEmpreinte qui renvoi le total des empreintes carbones
        u1.detaillerEmpreinte(); // Utilisation de la méthode detaillerEmpreinte
        u1.Ordonner(); // Méthode Ordonner

        // Calcul de l'empreinte total de l'utilisateur
        double[] tab ={a1.calc_impact(),b1.calc_impact(),s1.calc_impact(),l1.calc_impact(),t1.calc_impact()};
        double somme = 0;
        for(double i:tab){
            somme = somme + i;
        }
        // MENU
        int userSelected;
        do {
            userSelected = Menu.Menu.Menudata();
            switch(userSelected){
                case 1:
                    System.out.println("Empreinte Carbone du poste de consommation de l'Alimentation : "+ a1.calc_impact());
                    break;
                case 2:
                    System.out.println("Empreinte Carbone du poste de consommation des Dépenses et Biens de Consommations  : "+ b1.calc_impact());
                    break;
                case 3:
                    System.out.println("Empreinte Carbone du poste de consommation des Services Publics : "+ s1.calc_impact());
                    break;
                case 4:
                    System.out.println("Empreinte Carbone du poste de consommation de Logement : "+ l1.calc_impact());
                    break;
                case 5:
                    System.out.println("Empreinte Carbone du poste de consommation de Déplacement et Transport : "+ t1.calc_impact());
                    break;
                case 6:
                    System.out.println("Empreinte Carbone Total de l'utilisateur : "+ somme );
                    break;
                case 7:
                    System.out.println("Vous avez quitté le menu");
                    break;
                default:
                    break;
            }
        } while (userSelected != 7);
}
}
