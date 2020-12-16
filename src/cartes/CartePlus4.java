package cartes;

import uno.Uno;

public class CartePlus4 extends Carte {
    public CartePlus4(Uno uno) {
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
        return 6;
    }

    @Override
    public void appliquerEffet() {
        getUno().distribuerCartesJoueurSuivant(4);
    }

    @Override
    public boolean peutEtrePoseeSur(CartePlus4 c) {
        return true;
    }

    @Override
    public String toString() {
        if (getCouleur() != null) {
            return "+4 " + getCouleur();
        }
        return "+4";
    }
}
