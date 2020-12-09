package cartes;

import uno.Uno;

public class CartePasseTonTour extends Carte {
    public CartePasseTonTour(Uno uno, Couleur couleur) {
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
        return 4;
    }

    @Override
    public void appliquerEffet() {
        getUno().changerDeJoueur();
    }

    @Override
    public boolean peutEtrePoseeSur(CartePasseTonTour c) {
        return true;
    }

    @Override
    public String toString() {
        return "Carte PasseTonTour de couleur " + getCouleur();
    }
}
