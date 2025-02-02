package cartes;

import uno.Uno;

public class CartePlus2 extends Carte {
    public CartePlus2(Uno uno, Couleur couleur) {
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
        return 5;
    }

    @Override
    public void appliquerEffet() {
        getUno().distribuerCartesJoueurSuivant(2);
    }

    @Override
    public boolean peutEtrePoseeSur(CartePlus2 c) {
        return true;
    }

    @Override
    public String toString() {
        return "+2 " + getCouleur();
    }
}
