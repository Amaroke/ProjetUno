package dialogue;

import joueurs.Strategie;
import joueurs.StrategieDifficile;
import joueurs.StrategieFacile;
import joueurs.StrategieMoyen;
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
        Strategie strategieChoisie = null;
        while (!choixJoueurCorrect) {
            try {
                System.out.println("Bienvenue dans cette partie de Uno ! \uD83E\uDD2A");
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
                    switch (strategie) {
                        case 1:
                            strategieChoisie = new StrategieFacile();
                            break;
                        case 2:
                            strategieChoisie = new StrategieMoyen();
                            break;
                        case 3:
                            strategieChoisie = new StrategieDifficile();
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("\nExcuse-moi, mais ce n'est pas un nombre ou alors il est un peu grand...\n");
                scanner = new Scanner(System.in);
            }
        }
        this.uno.initialiser(nbJoueurs, strategieChoisie);
    }

    public void mettreAJour() {
        System.out.println("Il reste " + getUno().getPioche().getNombreDeCartes() + " cartes dans la pioche.\n");
        for (int i = 2; i <= uno.getNbJoueurs(); ++i) {
            System.out.println("Vous pouvez voir qu'il reste " + getUno().getJoueur(i).getMainDuJoueur().getNombreDeCartes() + " cartes dans la main du joueur " + i + ".");
        }
        System.out.println("\nLa carte en haut du talon est : " + getUno().getTalon().getSommet());
        System.out.println("\nVotre main est la suivante :");
        for (int i = 0; i < getUno().getJoueur(1).getMainDuJoueur().getNombreDeCartes(); ++i) {
            System.out.println(i + " : " + getUno().getJoueur(1).getCarteNumero(i));
        }
        System.out.println();
    }

    public String taperUnChoix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nC'est à votre tour ! Que voulez-vous jouer ?");
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

    public void afficherScore(int n, int nb) {
        System.out.println("Le joueur " + n + " à un score de : " + nb);
    }

    public void afficherMonScore(int nb) {
        System.out.println("Votre score est de : " + nb);
    }

    public void finDuJeu() {
        System.out.println("\nLa partie est terminée ! Merci d'avoir joué !");
    }

    public String choisirCouleurCartePiocheJoker() {
        List<String> couleurs = List.of("r", "v", "b", "j");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous avez pioché un Joker et vous allez le jouer, quelle couleur souhaitez-vous pour lui ?");
        String choix = "";
        while (!couleurs.contains(choix)) {
            System.out.print("(r, v, b ou j) : ");
            choix = scanner.nextLine();
        }
        return choix;
    }

    public String choisirCouleurCartePioche4() {
        List<String> couleurs = List.of("r", "v", "b", "j");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous avez pioché un +4 et vous allez le jouer, quelle couleur souhaitez-vous pour lui ?");
        String choix = "";
        while (!couleurs.contains(choix)) {
            System.out.print("(r, v, b ou j) : ");
            choix = scanner.nextLine();
        }
        return choix;
    }
}
