package dialogue;

import uno.Uno;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class DialogueLigneDeCommande {

    private final Uno uno;

    public Uno getUno() {
        return uno;
    }

    public DialogueLigneDeCommande(Uno uno) {
        boolean choixJoueurCorrect = false;
        boolean choixStrategieCorrect = false;
        Scanner scanner = new Scanner(System.in);
        this.uno = uno;
        int nbJoueurs = 0;
        int strategie;
        while (!choixJoueurCorrect) {
            try {
                System.out.println("Bienvenue dans cette partie de Uno !");
                System.out.println("À combien de joueur voulez-vous jouer ?");
                System.out.print("Entre 2 et 10 : ");
                nbJoueurs = scanner.nextInt();
                if (nbJoueurs >= 2 && nbJoueurs <= 10) {
                    choixJoueurCorrect = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nExcuse-moi, mais ce n'est pas un nombre ou alors il est un peu grand...\n");
                scanner = new Scanner(System.in);
            }
        }
        while (!choixStrategieCorrect) {
            try {
                System.out.println("Quelle difficulté pour les Bots ?");
                System.out.print("(1 : Facile, 2 : Moyen ou 3 : Difficile) : ");
                strategie = scanner.nextInt();
                if (strategie >= 1 && strategie <= 3) {
                    choixStrategieCorrect = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nExcuse-moi, mais ce n'est pas un nombre ou alors il est un peu grand...\n");
                scanner = new Scanner(System.in);
            }
        }
        this.uno.initialiser(nbJoueurs);
    }

    public void mettreAJour() {
        System.out.println("La carte en haut du talon est : " + getUno().getTalon().getSommet());
        System.out.println("Il reste " + getUno().getPioche().getNombreDeCartes() + " cartes dans la pioche.\n");
        System.out.println("Votre main est la suivante :");
        for (int i = 0; i < getUno().getJoueur(1).getMainDuJoueur().getNombreDeCartes(); ++i) {
            System.out.println(i + " : " + getUno().getJoueur(1).getCarteNumero(i));
        }
        System.out.println();
    }

    public String taperUnChoix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("C'est à votre tour ! Que voulez-vous jouer ?");
        System.out.print("(Le numéro de votre carte, couplé à la première lettre de la couleur souhaitée si vous jouer une carte Joker ou Plus4) : ");
        return scanner.nextLine();
    }

    public void pauseBot() {
        System.out.println("L'IA réfléchit, patientez...\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void afficherErreur(String e) {
        System.out.println(e);
    }

    public String choisirCouleurCartePioche() {
        List<String> couleurs = List.of("r", "v", "b", "j");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous avez pioché un Joker et vous allez le jouer, quelle couleur souhaitez-vous pour lui ?");
        System.out.print("(r, v, b ou j) : ");
        String choix = "";
        while (!couleurs.contains(choix)) {
            System.out.print("(r, v, b ou j) : ");
            choix = scanner.nextLine();
        }
        return choix;
    }
}
