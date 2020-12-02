package uno;

import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;
import joueurs.Joueur;

import java.util.ArrayList;

public class Uno {

    private int nbJoueurs;
    private int joueurQuiJoue;
    private int joueurQuiDistribue;
    private ArrayList<Joueur> listeJoueurs;
    private boolean sensHorraire;
    private PaquetDeCartes pioche;
    private PaquetDeCartes talon;

    public Uno() {

    }

    public void initialiser(int nbJoueurs) {
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        talon = singleton.getPaquetVide();
        pioche = singleton.getPaquetDeUno();
        sensHorraire = true;
        assert (nbJoueurs >= 2) : "Le nombre de joueur n'est pas suffisant (<2).";
        assert (nbJoueurs <= 10) : "Le nombre de joueur est trop élevé (>10).";
        this.nbJoueurs = nbJoueurs;
        creerLesJoueurs(nbJoueurs);
        distribuerCartes();
        choisirQuiDistribue();
        choisirQuiJoue();
    }

    private void creerLesJoueurs(int nbJoueurs) {
        assert (nbJoueurs >= 2) : "Le nombre de joueur n'est pas suffisant (<2).";
        assert (nbJoueurs <= 10) : "Le nombre de joueur est trop élevé (>10).";
        listeJoueurs = new ArrayList<>(4);
        for (int i = 0; i < nbJoueurs; ++i) {
            listeJoueurs.add(new Joueur());
        }
    }

    public void choisirQuiJoue() {
        joueurQuiJoue = (int) (1 + (Math.random() * (nbJoueurs() - 1)));
    }

    private void choisirQuiDistribue() {
        if (joueurQuiJoue == nbJoueurs()) {
            joueurQuiDistribue = 1;
        } else {
            joueurQuiDistribue = joueurQuiJoue + 1;
        }
    }

    public void distribuerCartes() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < nbJoueurs(); ++i) {
                listeJoueurs.get(0).getMainDuJoueur().ajouter(talon.piocher());
            }
        }
        pioche.ajouter(talon.piocher());
    }

    public int nbJoueurs() {
        return nbJoueurs;
    }

    public void changerDeSens() {
        sensHorraire = !sensHorraire;
    }

    public void changerDeJoueur() {
        if (joueurQuiJoue == nbJoueurs()) {
            joueurQuiJoue = 1;
        } else {
            joueurQuiJoue = joueurQuiJoue + 1;
        }
    }

    public void distribuerCartesJoueurSuivant(int nb) {
        listeJoueurs.get(joueurQuiJoue + 1).getMainDuJoueur().ajouter(pioche.piocher());
    }
}
