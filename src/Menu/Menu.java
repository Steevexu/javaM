package Menu;

import java.util.Scanner;

public class Menu {
    public static int Menudata(){
        int selection;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix de l'empreinte Carbone du poste de consommation : ");
        System.out.println("----------------\n");
        System.out.println("1- Alimentation");
        System.out.println("2- Dépenses et Biens de Consommations");
        System.out.println("3- Services Publics");
        System.out.println("4- Logement");
        System.out.println("5- Déplacement et Transport");
        System.out.println("6- Empreinte carbone total");
        System.out.println("7- Quittez le menu");

        System.out.println("Votre choix est : ");
        selection = sc.nextInt();
        return selection;

    }

}
