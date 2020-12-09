package cartes;

import uno.Uno;

public class CarteChiffre extends Carte {
    private final int chiffre;

    public CarteChiffre(Uno uno, Couleur couleur, int chiffre) {
        super(uno, couleur);
        this.chiffre = chiffre;
    }

    @Override
    public boolean peutEtreRecouverte(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    @Override
    public int getValeur() {
        return chiffre;
    }

    @Override
    public int effet() {
        return 1;
    }

    @Override
    public void appliquerEffet() {
        getUno().changerDeJoueur();
    }

    @Override
    public boolean peutEtrePoseeSur(CarteChiffre c) {
        return estDeCouleurCompatible(c.getCouleur()) || getValeur() == c.getValeur();
    }

    @Override
    public String toString() {
        return "Carte Chiffre de couleur " + getCouleur() + " et de valeur " + getValeur();
    }
}
