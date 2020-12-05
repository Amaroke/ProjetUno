package joueurs;

import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;
import uno.Uno;

public class Joueur {

    private final PaquetDeCartes mainDuJoueur;
    private Uno uno;

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
}
