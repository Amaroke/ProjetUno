package cartes;

public class CartePlus2 extends Carte {
    CartePlus2 (Uno uno, Couleur couleur) {
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
        return 0;
    }

    @Override
    public boolean peutEtrePoseeSur(CartePlus2 c) {
        return true;
    }

}
