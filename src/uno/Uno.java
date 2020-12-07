package uno;

import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;
import joueurs.Bot;
import joueurs.Humain;
import joueurs.Joueur;

import java.util.ArrayList;

public class Uno {

    private int nbJoueurs;
    private ArrayList<Joueur> listeJoueurs;
    private int joueurQuiJoue;
    private int joueurQuiDistribue;
    private boolean sensHorraire;
    private PaquetDeCartes pioche;
    private PaquetDeCartes talon;

    public Uno() {
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public boolean getSensHorraire() {
        return sensHorraire;
    }

    public PaquetDeCartes getTalon() {
        return talon;
    }

    public PaquetDeCartes getPioche() {
        return pioche;
    }

    public void initialiser(int nbJoueurs) {
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        talon = singleton.getPaquetVide();
        pioche = singleton.getPaquetDeUno();
        sensHorraire = true;
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
        listeJoueurs.add(new Humain(this));
        for (int i = 1; i < nbJoueurs; ++i) {
            listeJoueurs.add(new Bot(this));
        }
    }

    private void choisirQuiDistribue() {
        joueurQuiDistribue = (int) (1 + (Math.random() * (getNbJoueurs() - 1)));
    }

    public void choisirQuiJoue() {
        joueurQuiJoue = joueurQuiDistribue == getNbJoueurs() ? 1 : joueurQuiDistribue +1;
    }

    public void distribuerCartes() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < getNbJoueurs(); ++i) {
                listeJoueurs.get(j).getMainDuJoueur().ajouter(talon.piocher());
            }
        }
        this.pioche.ajouter(this.talon.piocher());
    }

    public void changerDeSens() {
        sensHorraire = !sensHorraire;
    }

    public void changerDeJoueur() {
        if (getSensHorraire()) {
            joueurQuiJoue = (joueurQuiJoue == getNbJoueurs()) ? 1 : joueurQuiJoue + 1;
        }
        else {
            joueurQuiJoue = (joueurQuiJoue == 1) ? getNbJoueurs() : joueurQuiJoue - 1;
        }
    }

    public void distribuerCartesJoueurSuivant(int nb) {
        for (int i = 0; i < nb; ++i) {
            listeJoueurs.get(joueurQuiJoue + 1).getMainDuJoueur().ajouter(pioche.piocher());
        }
    }
}
