package uno;

import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;
import dialogue.DialogueLigneDeCommande;
import erreurs.CoupIncorrectException;
import joueurs.Joueur;
import joueurs.JoueurBot;
import joueurs.JoueurHumain;
import joueurs.Strategie;

import java.util.ArrayList;

public class Uno {

    private ArrayList<Joueur> listeJoueurs;
    private int nbJoueurs;
    private int joueurQuiJoue;
    private int joueurQuiDistribue;
    private boolean sensHoraire;
    private PaquetDeCartes pioche;
    private PaquetDeCartes talon;
    private DialogueLigneDeCommande dial;


    private boolean jeuTerminee;

    public Uno() {
        sensHoraire = true;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public Joueur getJoueur(int nb) {
        return listeJoueurs.get(nb - 1);
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

    public Joueur joueurQuiJoue() {
        return getJoueur(getJoueurQuiJoue());
    }

    public boolean getSensHoraire() {
        return sensHoraire;
    }

    public PaquetDeCartes getTalon() {
        return talon;
    }

    public DialogueLigneDeCommande getDial() {
        return dial;
    }

    public boolean isJeuTerminee() {
        return jeuTerminee;
    }

    public void setJeuTerminee(boolean jeuTerminee) {
        this.jeuTerminee = jeuTerminee;
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

    public void initialiser(int nbJoueurs, Strategie strategie) {
        jeuTerminee = false;
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        talon = singleton.getPaquetVide();
        pioche = singleton.getPaquetDeUno(this);
        pioche.melanger();
        creerLesJoueurs(nbJoueurs, strategie);
        distribuerCartes();
        choisirQuiDistribue();
        choisirQuiJoue();
    }

    public void creerLesJoueurs(int nbJoueurs, Strategie strategie) {
        assert (nbJoueurs >= 2) : "Le nombre de joueur n'est pas suffisant (<2).";
        assert (nbJoueurs <= 10) : "Le nombre de joueur est trop élevé (>10).";
        this.nbJoueurs = nbJoueurs;
        listeJoueurs = new ArrayList<>(nbJoueurs);
        listeJoueurs.add(new JoueurHumain(this));
        for (int i = 1; i < nbJoueurs; ++i) {
            listeJoueurs.add(new JoueurBot(this, strategie));
        }
    }

    public void choisirQuiDistribue() {
        joueurQuiDistribue = (int) ((Math.random() * (getNbJoueurs())));
    }

    public void choisirQuiJoue() {
        joueurQuiJoue = getJoueurQuiDistribue() == getNbJoueurs() ? 0 : getJoueurQuiDistribue() + 1;
    }

    public void distribuerCartes() {
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
        if (getJoueurQuiJoue() == getNbJoueurs()) {
            for (int i = 0; i < nb; ++i) {
                listeJoueurs.get(0).getMainDuJoueur().ajouter(pioche.piocher());
            }
        } else {
            for (int i = 0; i < nb; ++i) {
                listeJoueurs.get(joueurQuiJoue).getMainDuJoueur().ajouter(pioche.piocher());
            }
        }
    }

    public void jeu() {
        DialogueLigneDeCommande dial = new DialogueLigneDeCommande(this);
        setDialogue(dial);
        while (!isJeuTerminee()) {
            getDial().mettreAJour();
            if (joueurQuiJoue().estUnJoueurHumain()) {
                boolean coupIncorrect = true;
                while (coupIncorrect) {
                    try {
                        joueurQuiJoue().jouer(getDial().taperUnChoix());
                        coupIncorrect = false;
                    } catch (CoupIncorrectException e) {
                        getDial().afficherErreur(e.getMessage());
                    } catch (NumberFormatException e) {
                        getDial().afficherErreur("Il est un peu grand ton nombre là...");
                    }
                }
            } else {
                boolean coupIncorrect = true;
                while (coupIncorrect) {
                    try {
                        joueurQuiJoue().jouer("");
                        coupIncorrect = false;
                    } catch (CoupIncorrectException e) {
                        e.printStackTrace();
                    }
                }
                getDial().pauseBot();
            }
            for (int i = 0; i < getNbJoueurs(); i++) {
                if (getJoueur(i+1).getMainDuJoueur().getNombreDeCartes() == 0 || getPioche().getNombreDeCartes() == 0) {
                        getDial().afficherScore(i, getJoueur(i+1).getMainDuJoueur().getValeur());
                    setJeuTerminee(true);
                }
            }
            changerDeJoueur();
        }
    }
}
