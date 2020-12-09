package cartes;

import uno.Uno;

public class CarteJoker extends Carte {
    public CarteJoker(Uno uno) {
        super(uno);
    }

    @Override
    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    @Override
    public int getValeur() {
        return 50;
    }

    @Override
    public int effet() {
        return 3;
    }

    @Override
    public void appliquerEffet() {
        getUno().changerDeJoueur();
    }

    @Override
    public boolean peutEtrePoseeSur(CarteJoker c) {
        return true;
    }

    @Override
    public String toString() {
        return "Carte Joker";
    }
}