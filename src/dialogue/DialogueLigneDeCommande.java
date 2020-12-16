package dialogue;

import uno.Uno;

import java.util.Scanner;

public class DialogueLigneDeCommande {
    private final Uno uno;

    public DialogueLigneDeCommande(Uno uno) {
        boolean choixJoueurCorrect = false;
        boolean choixStrategieCorrect = false;
        Scanner scanner = new Scanner(System.in);
        this.uno = uno;
        int nbJoueurs = 0;
        int strategie;
        while (!choixJoueurCorrect) {
            System.out.println("Bienvenue dans cette partie de Uno !");
            System.out.println("À combien de joueur voulez-vous jouer ?");
            System.out.print("Entre 2 et 10 : ");
            nbJoueurs = scanner.nextInt();
            if(nbJoueurs >= 2 && nbJoueurs <= 10) {
                choixJoueurCorrect = true;
            }
        }
        while (!choixStrategieCorrect) {
            System.out.println("Quelle difficulté pour les Bots ?");
            System.out.print("(1 : Facile, 2 : Moyen ou 3 : Difficile) : ");
            strategie = scanner.nextInt();
            if(strategie >= 1 && strategie <= 3) {
                choixStrategieCorrect = true;
            }
        }
        uno.initialiser(nbJoueurs);
    }

    void mettreAJour() {

    }
}
