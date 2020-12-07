package joueurs;

import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;
import uno.Uno;

public abstract class Joueur {

    private final PaquetDeCartes mainDuJoueur;
    private final Uno uno;

    public Joueur(Uno uno) {
        FabriqueCartes singleton = FabriqueCartes.getInstance();
        mainDuJoueur = singleton.getPaquetVide();
        this.uno = uno;
    }

    public PaquetDeCartes getMainDuJoueur() {
        return mainDuJoueur;
    }

    public Uno getUno() {
        return uno;
    }

    public abstract void jouer(String coup);
}
