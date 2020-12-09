package uno;

import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;
import dialogue.DialogueLigneDeCommande;
import joueurs.JoueurBot;
import joueurs.Humain;
import joueurs.JoueurHumain;
import joueurs.StrategieFacile;

import java.util.ArrayList;

public class Uno {

    private ArrayList<JoueurHumain> listeJoueurs;
    private int joueurQuiJoue;
    private int joueurQuiDistribue;
    private boolean sensHoraire;
    private PaquetDeCartes pioche;
    private PaquetDeCartes talon;
    private DialogueLigneDeCommande dial;

    public Uno() {
        sensHoraire = true;
    }

    public int getNbJoueurs() {
        return listeJoueurs.size();
    }

    public JoueurHumain getJoueurs(int nb) {
        return listeJoueurs.get(nb-1);
    }

    public int getJoueurQuiDistribue() {
        return joueurQuiDistribue;
    }

    public void setJoueurQuiDistribue(int joueurQuiDistribue) {
        this.joueurQuiDistribue = joueurQuiDistribue;
    }

    public int getJoueurQuiJoue() {
        return joueurQuiJoue;
    }

    public boolean getSensHoraire() {
        return sensHoraire;
    }

    public PaquetDeCartes getTalon() {
        return talon;
    }

    public void setTalon(PaquetDeCartes talon) {
        this.talon = talon;
    }

    public PaquetDeCartes getPioche() {
        return pioche;
    }

    public void setPioche(PaquetDeCartes pioche) {
        this.pioche = pioche;
    }

    public void setDialogue(DialogueLigneDeCommande dial) {
        this.dial = dial;
    }

    public void initialiser(int nbJoueurs) {
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        talon = singleton.getPaquetVide();
        pioche = singleton.getPaquetDeUno();
        creerLesJoueurs(nbJoueurs);
        distribuerCartes();
        choisirQuiDistribue();
        choisirQuiJoue();
    }

    public void creerLesJoueurs(int nbJoueurs) {
        assert (nbJoueurs >= 2) : "Le nombre de joueur n'est pas suffisant (<2).";
        assert (nbJoueurs <= 10) : "Le nombre de joueur est trop élevé (>10).";
        listeJoueurs = new ArrayList<>(nbJoueurs);
        listeJoueurs.add(new Humain(this));
        for (int i = 1; i < nbJoueurs; ++i) {
            listeJoueurs.add(new JoueurBot(this, new StrategieFacile()));
        }
    }

    public void choisirQuiDistribue() {
        joueurQuiDistribue = (int) ((Math.random() * (getNbJoueurs())));
    }

    public void choisirQuiJoue() {
        joueurQuiJoue = getJoueurQuiDistribue() == getNbJoueurs() ? 0 : getJoueurQuiDistribue() + 1;
    }

    public void distribuerCartes() {
        this.pioche.melanger();
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < getNbJoueurs(); ++j) {
                listeJoueurs.get(j).getMainDuJoueur().ajouter(pioche.piocher());
            }
        }
        talon.ajouter(pioche.piocher());
    }

    public void changerDeSens() {
        sensHoraire = !sensHoraire;
    }

    public void changerDeJoueur() {
        if (getSensHoraire()) {
            joueurQuiJoue = (joueurQuiJoue == getNbJoueurs()) ? 1 : joueurQuiJoue + 1;
        } else {
            joueurQuiJoue = (joueurQuiJoue == 1) ? getNbJoueurs() : joueurQuiJoue - 1;
        }
    }

    public void distribuerCartesJoueurSuivant(int nb) {
        for (int i = 0; i < nb; ++i) {
            listeJoueurs.get(joueurQuiJoue + 1).getMainDuJoueur().ajouter(pioche.piocher());
        }
    }
}
