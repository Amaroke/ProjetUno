package cartes;

import uno.Uno;

public class CarteChangementDeSens extends Carte {

    CarteChangementDeSens(Uno uno, Couleur couleur) {
        super(uno, couleur);
    }

    @Override
    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    @Override
    public int getValeur() {
        return 20;
    }

    @Override
    public int effet() {
        return 2;
    }

    @Override
    public void appliquerEffet() {
        getUno().changerDeSens();
        getUno().changerDeJoueur();
    }

    @Override
    public boolean peutEtrePoseeSur(CarteChangementDeSens c) {
        return true;
    }

    @Override
    public String toString() {
        return "Carte ChangementDeSens de couleur " + getCouleur();
    }
}
